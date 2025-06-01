package com.tubespbo.tubesweb.controller;

import com.tubespbo.tubesweb.controller.action.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "ControllerServlet", urlPatterns = {"/controller"})
public class ControllerServlet extends HttpServlet {

    private Properties props = null;
    private static final Logger LOGGER = Logger.getLogger(ControllerServlet.class.getName());

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            props = new Properties();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("conf.properties");
            if (in != null) {
                props.load(in);
            } else {
                LOGGER.log(Level.SEVERE, "Could not find conf.properties file.");
                throw new ServletException("Configuration file 'conf.properties' not found.");
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to read configuration file.", ex);
            throw new ServletException("Failed to read configuration file.", ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionClassName = null;
        String nextView = null;
        RequestDispatcher rds = null;

        if (action != null) {
            actionClassName = (String) props.get(action);
        }

        if (actionClassName != null) {
            try {
                ActionInterface actionInstance = (ActionInterface) Class.forName(actionClassName).getDeclaredConstructor().newInstance();
                nextView = actionInstance.execute(request);

                if (nextView != null && !nextView.contains("controller")) {
                    nextView = "/WEB-INF/page/" + nextView;
                }

                rds = request.getRequestDispatcher(nextView);
                rds.forward(request, response);

            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Controller Servlet Error", ex);
                request.setAttribute("errorMessage", ex.getMessage());
                rds = request.getRequestDispatcher("/WEB-INF/page/error.jsp");
                rds.forward(request, response);
            }
        } else {
            LOGGER.log(Level.WARNING, "No action mapped for: {0}", action);
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "The requested action is not available.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Main controller servlet that dispatches requests to action classes.";
    }
}