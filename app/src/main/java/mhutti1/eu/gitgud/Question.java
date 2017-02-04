package mhutti1.eu.gitgud;

/**
 * Created by mhutt on 04/02/2017.
 */

public class Question {

  private final String question;
  private final String firstOption;
  private final String secondOption;
  private final int userId;

  public Question(String question, String firstOption, String secondOption, int userId) {
    this.question = question;
    this.firstOption = firstOption;
    this.secondOption = secondOption;
    this.userId = userId;
  }


  public String getQuestion() {
    return question;
  }

  public String getFirstOption() {
    return firstOption;
  }

  public String getSecondOption() {
    return secondOption;
  }
}
