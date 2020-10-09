import edu.duke.URLResource;

import java.util.ArrayList;

public class Part4 {
    public void getYouTubeUrls() {
        ArrayList<String> urls = new ArrayList<String>();
        URLResource resource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        System.out.println(resource.lines());
        for (String item : resource.words()) {
            String itemLower = item.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = item.lastIndexOf("\"",pos); //find the specified string backwards
                int end = item.indexOf("\"", pos+1); //finds the specified string forwards
                System.out.println(item.substring(beg+1,end));
            }
        }
//        for(String ur: resource.words()) {
//            System.out.println(ur);
//        }
//        String contents = resource.asString().toLowerCase();
//        int subStringIndex = contents.indexOf("youtube.com");
//        int leftIndex = -1;
//        int rightIndex = -1;
//        while (subStringIndex >= 0){
//            for (int i = subStringIndex; i>0; i--){
//                if(contents.charAt(i) == '"'){
//                    leftIndex = i;
//                    break;
//                }
//            }
//
//            for (int j = subStringIndex; j<contents.length(); j++) {
//                if (contents.charAt(j) == '"') {
//                    rightIndex = j;
//                    break;
//                }
//            }
//
//            if (leftIndex >= 0 && rightIndex >= 0){
//                urls.add(contents.substring(leftIndex + 1, rightIndex));
//            }
//            subStringIndex = contents.indexOf("youtube.com", subStringIndex + 1);
//        }

        //return urls;
    }
    public static void main(String[] args) {
        //getYouTubeUrls();
        Part4 obj = new Part4();
        obj.getYouTubeUrls();
//        System.out.println(urls);
//        for (String url : urls) {
//            System.out.println(url);
//        }
    }
}
