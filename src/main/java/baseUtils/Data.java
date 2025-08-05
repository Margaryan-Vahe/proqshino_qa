package baseUtils;

public class Data {
    public enum UserTypes {
        DEFAULT_USER {
            public String phoneValidValue() {
                return "79321217816";
            }
            public String phoneFullValue() {
                return "+7 (932) 100-00-09";
            }
            public String phoneInvalidValue() {
                return "793212178";
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
                return "AUTOMATION";
            }

            public String userEmail() {
                return "user_simple@test.com";
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
        public String companyInn(){
            return "";
        }
    }
}
