package webprojectday06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculateScoreServlet
 */
@WebServlet("/CalculateScoreServlet")
public class CalculateScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();
		Question question = (Question)session.getAttribute("currentQs");
		
		int op = Integer.parseInt(request.getParameter("op"));
		
		Option selectedOption = question.getOptions().get(op);
		
		Integer score = (Integer)session.getAttribute("score");
		
		if(score == null)
			score = 0;
		if(selectedOption.isRightAnswer())
			score ++;
		session.setAttribute("score", score);

		response.sendRedirect("QuestionLoaderServlet");
		
		
	}

	

}
