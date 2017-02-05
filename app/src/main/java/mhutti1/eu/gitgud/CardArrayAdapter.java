package mhutti1.eu.gitgud;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhutt on 04/02/2017.
 */

public class CardArrayAdapter extends ArrayAdapter<Question> {

  private final List<Question> questions = new ArrayList();

  public CardArrayAdapter(Context context, int resource) {
    super(context, resource);
  }

  @Override
  public void add(Question question) {
    questions.add(0, question);
    super.add(question);
  }

  @Override
  public int getCount() {
    return questions.size();
  }

  @Override
  public Question getItem(int index) {
    return questions.get(index);
  }


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    final Question question = getItem(position);
    if (question.isConfirmed()) {
      QuestionViewHolder viewHolder;
      if (row == null || row.getTag() instanceof EditTextHolder) {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.cardviewconfirmed, parent, false);
        viewHolder = new QuestionViewHolder();
        viewHolder.question = (TextView) row.findViewById(R.id.question);
        viewHolder.firstOption = (Button) row.findViewById(R.id.firstOption);
        viewHolder.secondOption = (Button) row.findViewById(R.id.sectionOption);
        row.setTag(viewHolder);
      } else {
        viewHolder = (QuestionViewHolder) row.getTag();
      }
      viewHolder.question.setText(question.getQuestion());
      viewHolder.firstOption.setText(question.getFirstOption());
      viewHolder.secondOption.setText(question.getSecondOption());
    } else {
      final EditTextHolder viewHolder;
      if (row == null || row.getTag() instanceof QuestionViewHolder) {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.cardview, parent, false);
        viewHolder = new EditTextHolder();
        viewHolder.question = (TextView) row.findViewById(R.id.question);
        viewHolder.firstOption = (EditText) row.findViewById(R.id.firstOption);
        viewHolder.secondOption = (EditText) row.findViewById(R.id.sectionOption);
        row.setTag(viewHolder);
      } else {
        viewHolder = (EditTextHolder) row.getTag();
      }
      viewHolder.question.setText(question.getQuestion());
      viewHolder.firstOption.setHint(question.getFirstOption());
      viewHolder.secondOption.setHint(question.getSecondOption());
      viewHolder.firstOption.requestFocus();
      viewHolder.secondOption.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean hasFocus) {
          if (!hasFocus) {
            question.updateOptions(viewHolder.firstOption, viewHolder.secondOption);
          }
        }
      });
    }
    return row;
  }

  static class QuestionViewHolder {
    TextView question;
    Button firstOption;
    Button secondOption;
  }

  static class EditTextHolder {
    TextView question;
    EditText firstOption;
    EditText secondOption;
  }

}
