package webprojectday06;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public List<Question> loadQuestionsOnJava(){
		QuestionBank qb = new QuestionBank();
		qb.addNewSubject("java");
		 
		Question q = new Question("what is my name");
		
		List<Option> ops= new ArrayList<Option>();
		
		ops.add(new Option("abhishek",false));
		ops.add(new Option("Abhishek Dwivedi",true));
		ops.add(new Option("abhish",false));
		ops.add(new Option("abhi",false));
		
		q.setOptions(ops);
		
		qb.addNewQuestion("java", q);
		
		
		q = new Question("what is my surname");
		
		ops= new ArrayList<Option>();
		
		ops.add(new Option("Tiwari",false));
		ops.add(new Option("Dwivedi",true));
		ops.add(new Option("Trivedi",false));
		ops.add(new Option("shukla",false));
		
		q.setOptions(ops);
		
		qb.addNewQuestion("java", q);
		
		
		
		q = new Question("what is my name");
		
		 ops= new ArrayList<Option>();
		
		ops.add(new Option("abhishek",false));
		ops.add(new Option("Abhishek Dwivedi",true));
		ops.add(new Option("abhish",false));
		ops.add(new Option("abhi",false));
		
		q.setOptions(ops);
		
		qb.addNewQuestion("java", q);
		
		return qb.fetchQuestionOn("java");
		
		
		
		
		
		
		
		
	}
}
