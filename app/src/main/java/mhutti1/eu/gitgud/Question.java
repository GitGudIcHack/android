package mhutti1.eu.gitgud;

import android.widget.EditText;

/**
 * Created by mhutt on 04/02/2017.
 */

public class Question {

  private final String question;
  private String firstOption;
  private String secondOption;
  private final int userId;
  private boolean confirmed;

  public Question(String question, String firstOption, String secondOption, int userId, boolean confirmed) {
    this.question = question;
    this.firstOption = firstOption;
    this.secondOption = secondOption;
    this.userId = userId;
    this.confirmed = confirmed;
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

  public void updateOptions(EditText option1, EditText option2) {
    if (confirmed) {
      return;
    }
    if (option1.getText().length() > 0) {
      firstOption = option1.getText().toString();
    }
    if (option2.getText().length() > 0) {
      secondOption = option2.getText().toString();
    }
    this.confirm();
  }

  public void confirm() {
    confirmed = true;
  }

  public boolean isConfirmed() {
    return confirmed;
  }
}
