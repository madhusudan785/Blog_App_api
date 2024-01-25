package com.example.quizana.helper;

import com.example.quizana.data.Questions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionGenerator {

    public static List<Questions> getQuestions(){

      List<Questions>  list=new ArrayList<>();
      Questions questions=new Questions();
      questions.setqId(1);
      questions.setQuestion("What is java ?");
      questions.setOption1("Programming Language");
      questions.setOption2("Gaming app");
      questions.setOption3("Movie name");
      questions.setOption4("None");
      questions.setAnswer("Programming Language");

      list.add(questions);

        Questions question2 = new Questions();
        question2.setqId(2);
        question2.setQuestion("What does OOP stand for?");
        question2.setOption1("Object-Oriented Programming");
        question2.setOption2("Overly Obsessed Programmer");
        question2.setOption3("Open Office Platform");
        question2.setOption4("Online Order Processing");
        question2.setAnswer("Object-Oriented Programming");
        list.add(question2);


        Questions question3 = new Questions();
        question3.setqId(3);
        question3.setQuestion("Which programming language is known as the 'mother of all languages'?");
        question3.setOption1("C");
        question3.setOption2("Java");
        question3.setOption3("Assembly");
        question3.setOption4("Fortran");
        question3.setAnswer("Assembly");
        list.add(question3);


        Questions question4 = new Questions();
        question4.setqId(4);
        question4.setQuestion("What is the purpose of the 'finally' block in Java?");
        question4.setOption1("To handle exceptions");
        question4.setOption2("To define cleanup code");
        question4.setOption3("To specify conditions");
        question4.setOption4("To indicate the end of a loop");
        question4.setAnswer("To define cleanup code");
        list.add(question4);

        // Question 5
        Questions question5 = new Questions();
        question5.setqId(5);
        question5.setQuestion("What is the default value of the local variables in Java?");
        question5.setOption1("0");
        question5.setOption2("null");
        question5.setOption3("Depends on the data type");
        question5.setOption4("1");
        question5.setAnswer("Depends on the data type");
        list.add(question5);

      Questions question6 = new Questions();
      question6.setqId(9);
      question6.setQuestion("What is the capital of Japan?");
      question6.setOption1("Tokyo");
      question6.setOption2("Beijing");
      question6.setOption3("Seoul");
      question6.setOption4("Bangkok");
      question6.setAnswer("Tokyo");
      list.add(question6);


      Questions question7 = new Questions();
      question7.setqId(7);
      question7.setQuestion("Which planet is known as the Red Planet?");
      question7.setOption1("Earth");
      question7.setOption2("Mars");
      question7.setOption3("Jupiter");
      question7.setOption4("Venus");
      question7.setAnswer("Mars");
      list.add(question7);

      Questions question8 = new Questions();
      question8.setqId(8);
      question8.setQuestion("What is the largest mammal on Earth?");
      question8.setOption1("Elephant");
      question8.setOption2("Blue Whale");
      question8.setOption3("Giraffe");
      question8.setOption4("Hippopotamus");
      question3.setAnswer("Blue Whale");
      list.add(question8);

      Questions question9 = new Questions();
      question9.setqId(9);
      question9.setQuestion("Which programming language is known for its use in web development?");
      question9.setOption1("Java");
      question9.setOption2("C++");
      question9.setOption3("Python");
      question9.setOption4("HTML");
      question9.setAnswer("HTML");
      list.add(question9);


      Questions question10= new Questions();
      question10.setqId(10);
      question10.setQuestion("What is the currency of Australia?");
      question10.setOption1("Dollar");
      question10.setOption2("Euro");
      question10.setOption3("Yen");
      question10.setOption4("Pound");
      question5.setAnswer("Dollar");
      list.add(question10);

      Collections.shuffle(list);
        return list;

    }


}
