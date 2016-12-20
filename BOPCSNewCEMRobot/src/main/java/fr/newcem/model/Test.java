package fr.newcem.model;

/**
 * Created by moi on 18/12/2016.
 */
public class Test extends Template {
    private String actionExecutionDate;
    private int contratCode;


    public Test(Template parentActionTemplate, String actionExecutionDate, int contratCode){
        UpdateActionTemplate(parentActionTemplate);
        this.actionExecutionDate = actionExecutionDate;
        this.contratCode = contratCode;
    }
    public String getActionDate(){
        return this.actionExecutionDate;
    }

    public int getContratCode() {
        return contratCode;
    }

    public void setContratCode(int contratCode) {
        this.contratCode = contratCode;
    }
}
