/**
 * TODO
 *
 * @author ch
 * @version 1.0.0
 * @since 1.0.0
 *
 * Created at 2019-06-27 17:45
 */
public class DBbean {
  //字段序号	字段英文名	字段中文名	字段类型	主键是否	非空值	字段值说明
  private String number;
  private String englishName;
  private String chineseName;
  private String nameType;
  private boolean isKey;
  private boolean isNull;
  private String comment;


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getEnglishName() {
    return englishName;
  }

  public void setEnglishName(String englishName) {
    this.englishName = englishName;
  }

  public String getChineseName() {
    return chineseName;
  }

  public void setChineseName(String chineseName) {
    this.chineseName = chineseName;
  }

  public String getNameType() {
    return nameType;
  }

  public void setNameType(String nameType) {
    this.nameType = nameType;
  }

  public boolean isKey() {
    return isKey;
  }

  public void setKey(boolean key) {
    isKey = key;
  }

  public boolean isNull() {
    return isNull;
  }

  public void setNull(boolean aNull) {
    isNull = aNull;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "DBbean{" +
        "number='" + number + '\'' +
        ", englishName='" + englishName + '\'' +
        ", chineseName='" + chineseName + '\'' +
        ", nameType='" + nameType + '\'' +
        ", isKey=" + isKey +
        ", isNull=" + isNull +
        ", comment=" + comment +
        '}';
  }
}
