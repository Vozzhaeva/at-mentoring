package businessobject;

public class PasteBinTestData {
    private String code;
    private String pasteName;
    private String syntaxName;
    private String errorMessage;

    public PasteBinTestData(String code, String pasteName, String syntaxName, String errorMessage) {
        this.code = code;
        this.pasteName = pasteName;
        this.syntaxName = syntaxName;
        this.errorMessage = errorMessage;
    }

    public PasteBinTestData(String code, String pasteName, String syntaxName) {
        this.code = code;
        this.pasteName = pasteName;
        this.syntaxName = syntaxName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPasteName() {
        return pasteName;
    }

    public void setPasteName(String pasteName) {
        this.pasteName = pasteName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSyntaxName() {
        return syntaxName;
    }

    public void setSyntaxName(String syntaxName) {
        this.syntaxName = syntaxName;
    }
}