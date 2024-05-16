import java.util.*;
class Solution {
    static class Music {
        int time;
        String name, song;
        public Music(int time, String name, String song) {
            this.time = time;
            this.name = name;
            this.song = song;
        }
    }
    static ArrayList<Music> music = new ArrayList<>();
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        m = m.replace("C#", "Y")
                .replace("D#", "U")
                .replace("F#", "I")
                .replace("G#", "O")
                .replace("A#", "P")
                .replace("B#", "T");
        
        for(String str : musicinfos) {
            String[] abcd = str.split(",");
            int a = Integer.parseInt(abcd[0].substring(0,2)) * 60 
                + Integer.parseInt(abcd[0].substring(3,5));
            int b = Integer.parseInt(abcd[1].substring(0,2)) * 60 
                + Integer.parseInt(abcd[1].substring(3,5));
            int time = b - a;
            
            String name = abcd[2];
            
            String song = abcd[3].replace("C#", "Y")
                .replace("D#", "U")
                .replace("F#", "I")
                .replace("G#", "O")
                .replace("A#", "P")
                .replace("B#", "T");
            
            int length = song.length();
            
            if(time < length) {
                song = song.substring(0, time);
            }
            
            if(time > length) {
                int cnt = 0;
                for(int i=length; i<time; i++) {
                    song += song.charAt(cnt);
                    cnt++;
                    if(cnt == length) cnt = 0;
                }
            }
            
            music.add(new Music(time, name, song));
            // System.out.println(song);
        }
        
        int max = 0;
        int le = m.length();
        
        for(Music mu : music) {
            if(mu.song.contains(m) && max < mu.time) {
                max = mu.time;
                answer = mu.name;
            }
        }
//         for(Music mu : music) {
//             boolean flag = false;
//             if(le > mu.time) continue;
//             if(le == mu.time && m.equals(mu.song)) flag = true;
//             if(le < mu.time) {
//                 int lt = 0;
//                 int rt = le;
                
//                 String str = mu.song.substring(0,rt);
//                 while(true) {
//                     if(str.equals(m)) {
//                         flag = true;
//                         break;
//                     }
//                     str = str.substring(1,le);
//                     str += mu.song.charAt(rt);
                    
//                     lt++;
//                     rt++;
//                     if(rt == mu.time) break;
//                 }
//             }
            
//             if(flag && mu.time > max) {
//                 max = mu.time;
//                 answer = mu.name;
//             }
//         }
        
        if (answer.equals("")) answer = "(None)";
        return answer;
    }
}

// String 안에 어떤 String 이 있나 확인하는 명령어가 존재한다 ! 
// contains 라는 명령어를 기억하자 ! 
// String.contains(String) -> true or false