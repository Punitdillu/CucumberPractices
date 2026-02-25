package objectRepository;

import org.openqa.selenium.By;

public class LeadPage {

    public By AddbtnLeadPage = By.xpath("//button[@id='Leads_listView_basicAction_LBL_ADD_RECORD']");
    public By salutation = By.name("salutationtype");
    public By firstName = By.id("Leads_editView_fieldName_firstname");
    public By lastName = By.id("Leads_editView_fieldName_lastname");
    public By primaryPhone = By.id("Leads_editView_fieldName_phone");
    public By company = By.id("Leads_editView_fieldName_company");
    public By mobilePhone = By.id("Leads_editView_fieldName_mobile");
    public By designation = By.id("Leads_editView_fieldName_designation");
    public By fax = By.id("Leads_editView_fieldName_fax");
    public By leadSource = By.name("leadsource");
    public By email = By.id("Leads_editView_fieldName_email");
    public By industry = By.name("industry");
    public By website = By.id("Leads_editView_fieldName_website");
    public By annualRevenue = By.id("Leads_editView_fieldName_annualrevenue");
    public By leadStatus = By.name("leadstatus");
    public By noOfEmployees = By.id("Leads_editView_fieldName_noofemployees");
    public By rating = By.name("rating");
    public By secondaryEmail = By.id("Leads_editView_fieldName_secondaryemail");
    public By assignedTo = By.name("assigned_user_id");
    public By emailOptOut = By.id("Leads_editView_fieldName_emailoptout");
    public By street = By.id("Leads_editView_fieldName_lane");
    public By poBox = By.id("Leads_editView_fieldName_pobox");
    public By postalCode = By.id("Leads_editView_fieldName_code");
    public By city = By.id("Leads_editView_fieldName_city");
    public By country = By.id("Leads_editView_fieldName_country");
    public By state = By.id("Leads_editView_fieldName_state");
    public By description = By.id("Leads_editView_fieldName_description");
    public By savebtn = By.xpath("//button[normalize-space()='Save']");

}
