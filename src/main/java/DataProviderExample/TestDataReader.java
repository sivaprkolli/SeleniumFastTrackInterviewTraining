package DataProviderExample;

public class TestDataReader {
    private String propertyType;
    private String requestType;
    private String problemType;

    public String getPropertyType() {
        return propertyType;
    }

    public void propertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    @Override
    public String toString() {
        return "NewServiceRequestData{" +
                "propertyType='" + propertyType + '\'' +
                ", requestType='" + requestType + '\'' +
                ", problemType='" + problemType + '\'' +
                '}';
    }
}