package sg.edu.np.mad.mad_recyclerview;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ExampleViewHolder>{
    private ArrayList<myObject> mObjectList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public Button mButtonView;

        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.Task1);
            mButtonView = itemView.findViewById(R.id.checkBox);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (listener != null) { //need the listener to call the interface method
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){ //make sure the position is valid
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public CustomAdapter(ArrayList<myObject> objectList){
        mObjectList = objectList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }



    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        final myObject currentObject = mObjectList.get(position);

        holder.mTextView.setText(currentObject.getText());
        holder.mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentObject.isChecked()){
                    currentObject.setUnchecked();
                }
                else{
                    currentObject.setChecked(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mObjectList.size();
    }
}
