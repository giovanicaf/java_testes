import java.time.LocalDateTime;


class LogManager {
    private String id;
    private String companyId;
    private String unitId;
    private String userAction;
    private String entityId;
    private String entityName;
    private String action;
    private LocalDateTime dateTimeAction;
    private String jsonSettings;
    private DataStatus dataStatus;
    private String context;
    private String urlRequest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUserAction() {
        return userAction;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getDateTimeAction() {
        return dateTimeAction;
    }

    public void setDateTimeAction(LocalDateTime dateTimeAction) {
        this.dateTimeAction = dateTimeAction;
    }

    public String getJsonSettings() {
        return jsonSettings;
    }

    public void setJsonSettings(String jsonSettings) {
        this.jsonSettings = jsonSettings;
    }

    public DataStatus getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUrlRequest() {
        return urlRequest;
    }

    public void setUrlRequest(String urlRequest) {
        this.urlRequest = urlRequest;
    }

    public static LogManager createLogManager(String parametroName, String companyId, String userAction, String action, LocalDateTime dateTimeAction){
        LogManager logManager = new LogManager();
        logManager.setId("id " + parametroName);
        logManager.setCompanyId(companyId);
        logManager.setUnitId("UnitId ");
        logManager.setUserAction(userAction);
        logManager.setEntityId("EntityId ");
        logManager.setEntityName("EntityName ");
        logManager.setAction(action);
        logManager.setDateTimeAction(dateTimeAction);
        logManager.setJsonSettings("JsonSettings ");
        logManager.setDataStatus(DataStatus.ACTIVE);
        logManager.setContext("Context ");
        logManager.setUrlRequest("UrlRequest ");

        return logManager;
    }

    @Override
    public String toString() {
        return "LogManager{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", userAction='" + userAction + '\'' +
                ", entityId='" + entityId + '\'' +
                ", entityName='" + entityName + '\'' +
                ", action='" + action + '\'' +
                ", dateTimeAction=" + dateTimeAction +
                ", jsonSettings='" + jsonSettings + '\'' +
                ", dataStatus=" + dataStatus +
                ", context='" + context + '\'' +
                ", urlRequest='" + urlRequest + '\'' +
                '}';
    }
}