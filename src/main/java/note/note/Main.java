package note.note;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {


    public static void main(final String[] args) throws Exception{

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


        System.out.println(  passwordEncoder.encode("f") );




    }


}
