package webprojectday06;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		int qNo = 0;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		QuestionBankLoader qbLoader = new QuestionBankLoader();
		
		List<Question> questions  =qbLoader.loadQuestionsOnJava();
		
		
		if(qNo < questions.size()) {
			Question question = questions.get(qNo++);
			
			HttpSession session = request.getSession();
			session.setAttribute("currentQs", question);
			
			response.sendRedirect("viewQuestion.jsp");
		}
		else
			response.sendRedirect("viewScore.jsp");

	}
}
