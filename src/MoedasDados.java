public class MoedasDados {
    private String result;
    private String documentation;
    private String terms_of_use;
    private int time_last_update_unix;
    private String time_last_update_utc;
    private int time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public String getBase_code() {
        return this.base_code;
    }

    public String getTarget_code() {
        return this.target_code;
    }

    public double getConversion_result() {
        return this.conversion_result;
    }

    @Override
    public String toString() {
        return "A conversão de " + this.getBase_code() + " AMOUNT " + "resultou em " + this.target_code+ " " + this.getConversion_result();
    }
}
