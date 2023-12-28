package org.example.homeworkpro1;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet ("/question")//(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    static final String TEMPLATE = "<html>" +
            "<head><title>Prog Academy</title></head>" +
            "<body><h1>%s</h1></body></html>";
    private String message = "";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName"); // ім'я
        String lastName = request.getParameter("lastName"); // прізвище
        int age = 0; // вік
        try {
            age = Integer.parseInt(request.getParameter("age")); // перетворення рядка в ціле число
        } catch(NumberFormatException e) {
            System.out.println("Wrong input format!");
        }
        // рядкові змінні, значення яких залежить від вибору положення перемикачів
        String education = ""; // освіта
        String desire = ""; // бажання стрибнути в ІТ
        String radio1 = request.getParameter("radio1");
        String radio2 = request.getParameter("radio2");
        switch (radio1) {  // освіта
            case "1":
                education = "secondary";
                break;
            case "2":
                education = "higher";
                break;
        }
        switch (radio2) {  // бажання стрибнути в ІТ
            case "1":
                desire = "yes";
                break;
            case "2":
                desire = "no";
                break;
        }
        // логіка формування відповіді на запит користувача
        if(age < 60 && education.equals("higher") && desire.equals("yes")) {
            message = "Ви ідеальний кандидат.";
        }
        else if(desire.equals("no")) {
            message = "Шукайте іншу сферу діяльності.";
        }
        else {
            message = "Вам буде нелегко, але є шанс.";
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(String.format(TEMPLATE,message));
    }
}