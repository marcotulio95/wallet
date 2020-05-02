package br.com.marcotulio.wallet.exception;

public class ErrorDetails {

    private String title;
    private Integer status;
    private String detail;
    private Long timestamp;
    private String errorType;

    public String getTitle() {
        return title;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }


    public static final class ErrorDetailsBuilder {
        private String title;
        private Integer status;
        private String detail;
        private Long timestamp;
        private String errorType;

        private ErrorDetailsBuilder() {
        }

        public static ErrorDetailsBuilder newBuilder() {
            return new ErrorDetailsBuilder();
        }

        public ErrorDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ErrorDetailsBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ErrorDetailsBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public ErrorDetailsBuilder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetailsBuilder errorType(String errorType) {
            this.errorType = errorType;
            return this;
        }

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTitle(title);
            errorDetails.setStatus(status);
            errorDetails.setDetail(detail);
            errorDetails.setTimestamp(timestamp);
            errorDetails.setErrorType(errorType);
            return errorDetails;
        }
    }
}
