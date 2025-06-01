package com.tubespbo.tubesweb.controller.action;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Defines the contract for action classes that the ControllerServlet will use.
 * Each action class must implement this interface.
 */
public interface ActionInterface {

    String execute(HttpServletRequest request);
}