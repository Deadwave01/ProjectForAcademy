package com.vladwave.projectfortopacademy;

import EmployeesController.EmployeesController;
import javafx.css.Stylesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WritetoFile{

    public static void writeinfile(Employee u) throws IOException{
        String smd = u.toString();
        boolean o = true;
        Work
        String smdU;
        for(int i = 0; i < read().size(); i++){
            smdU = read().get(i).toString();
            o = (smd.equals(smdU)) ? true : false;
        }
        if(o == false){
            File file = new File("person");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(smd);
            writer.newLine();
            writer.close();
        } else {
            System.out.println("Данный пользователь уже есть в базе данных");
        }
    }

    public static ArrayList<Employee> read() throws IOException {
        ArrayList<Employee> lines = new ArrayList<>();
        String[] podline;
        String line;
        BufferedReader br = new BufferedReader(new FileReader("person"));
        while((line = br.readLine()) != null){
            podline = line.split(" ");
            lines.add(new Employee(podline[0],podline[1],podline[2],podline[3],podline[4],podline[5],podline[6],podline[7],podline[8],podline[9]));
        }
        for(int i = 0; i < lines.size(); i++){
            Employee.addEmployeeinList(lines.get(i));
        }
        return lines;
    }

    public static void deleteToFile(Employee e) throws IOException {
        File sourceFile = new File("person");
        File outputFile = new File("tmpperson");
        String outputLine = e.toString();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while ((line = reader.readLine()) != null) {
            if (!line.equals(outputLine)) {
                writer.write(line);
                writer.newLine();
            }
        }
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
        Employee.removeEmployeeinList(e);

    }
}
