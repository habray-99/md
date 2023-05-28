'''NF{
    EMPLOYEES (
    EMP_ID,
    EMP_NAME,
    EMP_ADDRESS,
    DEP_ID,
    DEP_NAME,
    DEP_LOCATION,
    {
    PRO_ID,
    PRO_NAME,
    PRO_DESC,
    PRO_EMP_BONUS,
    PRO_CAT_ID,
    PRO_CAT_NAME,
    PRO_CAT_DESC
    }
    )
}
'''
#######################################################################################33

1NF (removing repeating groups) # PRO=PROJECT
{
EMPLOYEES (
EMP_ID,
EMP_NAME,
EMP_ADDRESS,
DEP_ID,
DEP_NAME,
DEP_LOCATION
)

    project_details(
        EMP_ID,
        PRO_ID,
        PRO_NAME,
        PRO_DESC,
        PRO_EMP_BONUS
        PRO_CAT_ID,
        PRO_CAT_NAME,
        PRO_CAT_DESC
    )

}

##############################################################################################3

2NF (removing partial functional dependence) # REMOVING 2 PK TO 2 TABLES
EMP_ID, PRO_ID => PRO_EMP_BONUS
PRO_ID => PRO_NAME, PRO_DESC, PRO_CAT_ID, PRO_CAT_NAME, PRO_CAT_DESC
EMP_ID =>
{
EMPLOYEES (
EMP_ID,
EMP_NAME,
EMP_ADDRESS,
DEP_ID,
DEP_NAME,
DEP_LOCATION
)

    PROJECT_DETAILS(
        EMP_ID,
        PRO_ID,
        PRO_EMP_BONUS
    )

    PROJECT(
        PRO_ID
        PRO_NAME,
        PRO_DESC,
        PRO_CAT_ID,
        PRO_CAT_NAME,
        PRO_CAT_DESC
    )

}

########################################################################################

3NF (removing transitive dependencies) #removing the remaining pk from untouched
EMP_ID => DEP_ID => DEP_NAME, DEP_LOCATION # ALWAYS SHOW TRANSITIVE FIRST
EMP_ID => EMP_NAME, EMP_ADDRESS, DEP_ID

DEP_ID => DEP_NAME, DEP_LOCATION

PRO_ID => PRO_CAT_ID => PRO_CAT_NAME, PRO_CAT_DESC
PRO_ID => PRO_NAME, PRO_DESC, PRO_CAT_ID

PRO_CAT_ID => PRO_CAT_NAME, PRO_CAT_DESC

{
    Departments(
    DEP_ID,
    DEP_NAME,
    DEP_LOCATION
    )

    EMPLOYEES(
        EMP_ID,
        DEP_ID,
        EMP_ADDRESS,
    )

    PROJECT_DETAILS(
        EMP_ID,
        PRO_ID,
        PRO_EMP_BONUS
    )

    PROJECTS(
        PRO_ID,
        PRO_CAT_ID
        PRO_NAME,
        PRO_DESC,
    )

    PROJECTS_CATAGORIES(
        PRO_CAT_ID,
        PRO_CAT_NAME,
        PRO_CAT_DESC
    )

}
