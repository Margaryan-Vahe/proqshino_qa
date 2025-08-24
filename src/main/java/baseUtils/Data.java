package baseUtils;

public class Data {
    public enum UserTypes {
        DEFAULT_USER {
            public String phoneValidValue() {
                return "79330000000";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-00";
            }

            public String phoneInvalidValue() {
                return "793300000";
            }

            public String passwordValidValue() {
                return "Password1";
            }

            public String passwordInvalidValue() {
                return "Password123";
            }

            public String passwordIncorrectValue() {
                return "Password";
            }

            public String userFirstName() {
                return "USER";
            }

            public String userSecondName() {
                return "TEST";
            }

            public String userLastName() {
                return "DEFAULT";
            }

            public String userEmail() {
                return "9330000000@test.com";
            }
        },
        NOT_APPROVED_USER {
            public String phoneValidValue() {
                return "79330000001";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-01";
            }

            public String phoneInvalidValue() {
                return "793300000";
            }

            public String passwordValidValue() {
                return "Password1";
            }

            public String passwordInvalidValue() {
                return "Password123";
            }

            public String passwordIncorrectValue() {
                return "Password";
            }

            public String userFirstName() {
                return "USER";
            }

            public String userSecondName() {
                return "TEST";
            }

            public String userLastName() {
                return "NOT-APPROVED";
            }

            public String userEmail() {
                return "9330000001@test.com";
            }
        },
        APPROVED_USER {
            public String phoneValidValue() {
                return "79330000002";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-02";
            }

            public String phoneInvalidValue() {
                return "793300000";
            }

            public String passwordValidValue() {
                return "Password1";
            }

            public String passwordInvalidValue() {
                return "Password123";
            }

            public String passwordIncorrectValue() {
                return "Password";
            }

            public String userFirstName() {
                return "USER";
            }

            public String userSecondName() {
                return "TEST";
            }

            public String userLastName() {
                return "APPROVED";
            }

            public String userEmail() {
                return "9330000002@test.com";
            }
        };

        public String phoneValidValue() {
            return "";
        }

        public String phoneFullValue() {
            return "";
        }

        public String phoneInvalidValue() {
            return "";
        }

        public String passwordValidValue() {
            return "";
        }

        public String passwordInvalidValue() {
            return "";
        }

        public String passwordIncorrectValue() {
            return "";
        }

        public String userFirstName() {
            return "";
        }

        public String userSecondName() {
            return "";
        }

        public String userLastName() {
            return "";
        }

        public String userEmail() {
            return "";
        }

        public String companyInn() {
            return "";
        }
    }
}
