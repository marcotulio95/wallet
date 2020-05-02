package br.com.marcotulio.wallet.exception;

public class ModelNotFoundDetails extends ErrorDetails {

    public static final class Builder {
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

        public ModelNotFoundDetails build() {
            ModelNotFoundDetails modelNotFoundDetail = new ModelNotFoundDetails();
            modelNotFoundDetail.setTitle(title);
            modelNotFoundDetail.setStatus(status);
            modelNotFoundDetail.setDetail(detail);
            modelNotFoundDetail.setTimestamp(timestamp);
            modelNotFoundDetail.setErrorType(errorType);
            return modelNotFoundDetail;
        }
    }
}
