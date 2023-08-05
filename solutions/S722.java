package solutions;

import java.util.ArrayList;
import java.util.List;

public class S722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inBlockComment = false;
        for (String s : source) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (inBlockComment) {
                    if (c == '*' && i + 1 < n && s.charAt(i + 1) == '/') {
                        inBlockComment = false;
                        i++;
                    }
                } else {
                    if (c == '/' && i + 1 < n) {
                        char d = s.charAt(i + 1);
                        if (d == '/') {
                            break;
                        } else if (d == '*') {
                            inBlockComment = true;
                            i++;
                        } else {
                            sb.append(c);
                        }
                    } else {
                        sb.append(c);
                    }
                }
            }
            if (!inBlockComment && sb.length() != 0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }

        return res;
    }
}
