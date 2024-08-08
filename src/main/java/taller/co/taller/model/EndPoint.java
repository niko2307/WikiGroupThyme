package taller.co.taller.model;
import java.util.List;

public class EndPoint {
    private String endpointName;
    private String httpMethod;
    private String url;
    private String description;
    private List<Parameter> parameters;
    private String requestBody;
    private List<Header> headers;
    private String response;
    private List<StatusCode> statusCodes;
    private boolean authenticationRequired;
    private String usageExamples;
    private String notes;

    public EndPoint() {
    }

    public EndPoint(String endpointName, String httpMethod, String url, String description, List<Parameter> parameters,
            String requestBody, List<Header> headers, String response, List<StatusCode> statusCodes,
            boolean authenticationRequired, String usageExamples, String notes) {
        this.endpointName = endpointName;
        this.httpMethod = httpMethod;
        this.url = url;
        this.description = description;
        this.parameters = parameters;
        this.requestBody = requestBody;
        this.headers = headers;
        this.response = response;
        this.statusCodes = statusCodes;
        this.authenticationRequired = authenticationRequired;
        this.usageExamples = usageExamples;
        this.notes = notes;
    }

    public String getEndpointName() {
        return endpointName;
    }

    public void setEndpointName(String endpointName) {
        this.endpointName = endpointName;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<StatusCode> getStatusCodes() {
        return statusCodes;
    }

    public void setStatusCodes(List<StatusCode> statusCodes) {
        this.statusCodes = statusCodes;
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }

    public void setAuthenticationRequired(boolean authenticationRequired) {
        this.authenticationRequired = authenticationRequired;
    }

    public String getUsageExamples() {
        return usageExamples;
    }

    public void setUsageExamples(String usageExamples) {
        this.usageExamples = usageExamples;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Clases anidadas para Parameter, Header y StatusCode
    public static class Parameter {
        private String name;
        private String type;
        private boolean required;
        private String description;
        
        public Parameter(String name, String type, boolean required, String description) {
            this.name = name;
            this.type = type;
            this.required = required;
            this.description = description;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public boolean isRequired() {
            return required;
        }
        public void setRequired(boolean required) {
            this.required = required;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        // Constructor, Getters y Setters
        
    }

    public static class Header {
        private String name;
        private String value;
        
        public Header(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }

        // Constructor, Getters y Setters
        
    }

    public static class StatusCode {
        private int code;
        private String message;

        // Constructor, Getters y Setters
        public StatusCode(int code, String message) {
            this.code = code;
            this.message = message;
        }
        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }

    }
}

