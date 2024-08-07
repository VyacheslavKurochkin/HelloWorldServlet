package ru.kurochkin.helloworldservlet.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.Enumeration;

public class HelloWorldServlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String htmlTableRowTemplate = """
                <tr>
                    <td>%s</td>
                    <td>%s</td>
                </tr>
                """;

        StringBuilder parametersHtmlTableRows = new StringBuilder();
        Enumeration<String> initParametersNames = getInitParameterNames();

        while (initParametersNames.hasMoreElements()) {
            String parameterName = initParametersNames.nextElement();
            parametersHtmlTableRows.append(htmlTableRowTemplate.formatted(parameterName, getInitParameter(parameterName)));
        }

        Enumeration<String> contextInitParameters = getServletContext().getInitParameterNames();

        while (contextInitParameters.hasMoreElements()) {
            String parameterName = contextInitParameters.nextElement();
            parametersHtmlTableRows.append(htmlTableRowTemplate.formatted(parameterName, getServletContext().getInitParameter(parameterName)));
        }

        resp.getWriter().println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Hello world servlets</title>
                    <meta charset="UTF-8">
                </head>
                <body>
                    <h1>Параметры сервлета 2</h1>
                    <table border="1">
                        <thead>
                        <tr>
                            <th>Параметр</th>
                            <th>Значение</th>
                        </tr>
                        </thead>
                        <tbody>
                        %s
                        </tbody>
                    </table>
                </body>
                </html>
                """.formatted(parametersHtmlTableRows));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Servlet2: method post is OK");
    }
}