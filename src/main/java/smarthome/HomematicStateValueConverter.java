package smarthome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomematicStateValueConverter implements StateValueConverter {

  @Override
  public Integer convert(String in) {
    Pattern pattern = Pattern.compile(".*value='(.*?)'.*");
    Matcher matcher = pattern.matcher(in);
    String value;
    if (matcher.matches()) {
      value = matcher.group(1);
    } else {
      value = null;
    }
    return (int) (Math.round(Double.valueOf(value) * 100));
  }

}
