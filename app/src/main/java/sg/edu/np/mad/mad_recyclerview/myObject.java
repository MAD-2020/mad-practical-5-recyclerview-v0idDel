package sg.edu.np.mad.mad_recyclerview;

public class myObject {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setUnchecked() {
        this.checked = false;
    }

    private boolean checked;


    public myObject(){

    }

    public myObject(String text, boolean checked){
        this.checked =checked;
        this.text = text;
    }

}
