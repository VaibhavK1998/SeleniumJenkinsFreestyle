package utility;

import io.qameta.allure.Step;

import java.io.File;

public class DeleteAllureReport {

    @Step("delete previous allure report")
    public static void deleteAllureReports(){
        // comment for testinmg
                File directory = new File("allure-results");
                if (directory.exists()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            file.delete();
                        }
                    }
                    System.out.println("Allure report files deleted.");
                } else {
                    System.out.println("Allure report directory does not exist.");
                }
            }

        }



