package mhutti1.eu.gitgud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
  public void add(Question object) {
    questions.add(object);
    super.add(object);
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
    QuestionViewHolder viewHolder;
    if (row == null) {
      LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      row = inflater.inflate(R.layout.cardview, parent, false);
      viewHolder = new QuestionViewHolder();
      viewHolder.question = (TextView) row.findViewById(R.id.question);
      viewHolder.firstOption = (Button) row.findViewById(R.id.firstOption);
      viewHolder.secondOption = (Button) row.findViewById(R.id.sectionOption);
      row.setTag(viewHolder);
    } else {
      viewHolder = (QuestionViewHolder) row.getTag();
    }
    Question question = getItem(position);
    viewHolder.question.setText(question.getQuestion());
    viewHolder.firstOption.setText(question.getFirstOption());
    viewHolder.secondOption.setText(question.getSecondOption());
    return row;
  }


  static class QuestionViewHolder {
    TextView question;
    Button firstOption;
    Button secondOption;
  }

}
