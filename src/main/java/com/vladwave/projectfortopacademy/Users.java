package com.vladwave.projectfortopacademy;

import java.io.*;
import java.util.ArrayList;

public class Users {
    private String Login;
    private String Password;
    private UsersRole role;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public UsersRole getRole() {
        return role;
    }

    public void setRole(UsersRole role) {
        this.role = role;
    }

    public Users(String login, String password) {
        Login = login;
        Password = password;
        role = UsersRole.DEFAULT;
    }
    @Override
    public String toString(){
        return getLogin() + " " + getPassword() + " " + getRole().name;
    }

    public static void writeinfile(Users u) throws IOException, ClassNotFoundException {
        String smd = u.toString();
        boolean o = true;
        String smdU;
        for(int i = 0; i < read().size(); i++){
            smdU = read().get(i).toString();
            o = (smd.equals(smdU)) ? true : false;
        }
        if(o == false){
            String user = u.getLogin() + " " + u.getPassword() + " " + u.getRole().name();
            File file = new File("users");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(user);
            writer.newLine();
            writer.close();
        } else {
            System.out.println("Данный пользователь уже есть в базе данных");
        }
    }

    public Users(String login, String password, UsersRole role) {
        Login = login;
        Password = password;
        this.role = role;
    }

    public static ArrayList<Users> read() throws IOException, ClassNotFoundException {
        ArrayList<Users> lines = new ArrayList<>();
        String[] podline;
        String line;
        BufferedReader br = new BufferedReader(new FileReader("users"));
        while((line = br.readLine()) != null){
            podline = line.split(" ");
            lines.add(new Users(podline[0],podline[1],UsersRole.getRoleFromString(podline[2])));
        }
        return lines;
    }
}
