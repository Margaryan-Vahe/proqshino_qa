package baseUtils;

public class Data {
    public static final String SZ_A101_INN = "7751172550";
    public static final String COMPANY_ID = "b4246903-c11e-11ef-aa27-c4346bb2ae00";
    protected final static String MS_DB_DEV_URL = "jdbc:postgresql://rc1b-crt97mlp0v7r0ba5.mdb.yandexcloud.net:6432/master_system_dev?targetServerType=master&ssl=true&sslmode=verify-full";
    protected final static String MS_DB_DEV_USER = "master_system_dev";
    protected final static String MS_DB_DEV_PASSWORD = "sewjTCpbJ9ZS";

    protected final static String MS_DB_PROD_URL = "jdbc:postgresql://rc1b-crt97mlp0v7r0ba5.mdb.yandexcloud.net:6432/master_system_prod?targetServerType=master&ssl=true&sslmode=verify-full";
    protected final static String MS_DB_PROD_USER = "master_system_prod";
    protected final static String MS_DB_PROD_PASSWORD = "Cz3Yf*NW?TUU\\4t?%FQq";

    public enum UserTypes {
        DEFAULT_EMPLOYEE {
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
        NOT_APPROVED_EMPLOYEE {
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
        APPROVED_EMPLOYEE {
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
        },
        WITH_QR_EMPLOYEE {
            public String phoneValidValue() {
                return "79330000003";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-03";
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
                return "WITH-QR";
            }

            public String userEmail() {
                return "9330000003@test.com";
            }
        },
        FOR_SIMPLE_REGISTRATION_EMPLOYEE {
            public String phoneValidValue() {
                return "79330000004";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-04";
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
                return "REGISTRATION";
            }

            public String userEmail() {
                return "9330000004@test.com";
            }
        },
        FOR_SIMPLE_REGISTRATION_USER {
            public String phoneValidValue() {
                return "79330000005";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-05";
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
                return "USER";
            }

            public String userEmail() {
                return "9330000005@test.com";
            }
        },
        NOT_ACTIVATED_EMPLOYEE {
            public String phoneValidValue() {
                return "79330000006";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-06";
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
                return "NOT_ACTIVATED";
            }

            public String userSecondName() {
                return "TEST";
            }

            public String userLastName() {
                return "EMPLOYEE";
            }

            public String userEmail() {
                return "9330000006@test.com";
            }
        },
        FOR_VALIDATION_TEST_USER {
            public String phoneValidValue() {
                return "79330000007";
            }

            public String phoneFullValue() {
                return "+7 (933) 000-00-07";
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
                return "VALIDATION";
            }

            public String userSecondName() {
                return "TEST";
            }

            public String userLastName() {
                return "USER";
            }

            public String userEmail() {
                return "9330000000@test.com";
            }
        },
        NOT_REGISTERED_PHONE {
            public String phoneValidValue() {
                return "79330000008";
            }

            public String passwordValidValue() {
                return "Password1";
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
