package br.com.marcotulio.wallet.exception;

import java.util.List;

public class ValidationErrorDetails extends ErrorDetails {

    private String field;
    private List<String> fieldMessage;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<String> getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(List<String> fieldMessage) {
        this.fieldMessage = fieldMessage;
    }


    public static final class Builder {
        private String field;
        private List<String> fieldMessage;
        private String title;
        private Integer status;
        private String detail;
        private Long timestamp;
        private String errorType;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(List<String> fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder errorType(String errorType) {
            this.errorType = errorType;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setField(field);
            validationErrorDetails.setFieldMessage(fieldMessage);
            validationErrorDetails.setTitle(title);
            validationErrorDetails.setStatus(status);
            validationErrorDetails.setDetail(detail);
            validationErrorDetails.setTimestamp(timestamp);
            validationErrorDetails.setErrorType(errorType);
            return validationErrorDetails;
        }
    }
}