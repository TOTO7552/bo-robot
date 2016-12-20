package fr.newcem.model;

/**
 * Created by moi on 18/12/2016.
 */
public class Template {
    private String name;
    private String filMarque;
    private String filPdv;
    private String vin;
    private String action;
    private String dpiMadax;
    private String ddc;
    private String numeroClient;

        public Template(){
                name = "templateTest";
                filMarque = "AC";
                filPdv = "999999M";
                vin = "VF7CDCD5651651651";
                action = "SO";
                dpiMadax = "";
                ddc = "DateDuJour, 06/02/2016";
                numeroClient = "0000000009845";
        }

        public Template(String testName, String filMarque, String filPdv, String vin, String action, String dpiMadax, String ddc, String numeroClient){
                this.name = testName;
                this.filMarque = filMarque;
                this.filPdv = filPdv;
                this.vin = vin;
                this.action = action;
                this.dpiMadax = dpiMadax;
                this.ddc = ddc;
                this.numeroClient = numeroClient;
        }

    public void UpdateActionTemplate(Template template){
        this.name = template.getName();
        this.filMarque = template.getFilMarque();
        this.filPdv = template.getFilPdv();
        this.vin = template.getVin();
        this.action = template.getAction();
        this.dpiMadax = template.getDpiMadax();
        this.ddc = template.getDdc();
        this.numeroClient = template.getNumeroClient();
    }
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getFilMarque() {
                return filMarque;
        }

        public void setFilMarque(String filMarque) {
                this.filMarque = filMarque;
        }

        public String getFilPdv() {
                return filPdv;
        }

        public void setFilPdv(String filPdv) {
                this.filPdv = filPdv;
        }

        public String getVin() {
                return vin;
        }

        public void setVin(String vin) {
                this.vin = vin;
        }

        public String getAction() {
                return action;
        }

        public void setAction(String action) {
                this.action = action;
        }

        public String getDpiMadax() {
                return dpiMadax;
        }

        public void setDpiMadax(String dpiMadax) {
                this.dpiMadax = dpiMadax;
        }

        public String getDdc() {
                return ddc;
        }

        public void setDdc(String ddc) {
                this.ddc = ddc;
        }

        public String getNumeroClient() {
                return numeroClient;
        }

        public void setNumeroClient(String numeroClient) {
                this.numeroClient = numeroClient;
        }
}
