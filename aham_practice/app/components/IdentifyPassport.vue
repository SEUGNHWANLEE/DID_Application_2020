<template>
    <Page>
        <FlexboxLayout class="background">
            <FlexboxLayout flexDirection="column">
                <TextField id="info" v-model="Type" hint="종류 / Type"></TextField>
                <TextField id="info" v-model="PassportNo" hint="여권번호 / Passport No."></TextField>
                <TextField id="info" v-model="Surname" hint="성 / Surname"></TextField>
                <TextField id="info" v-model="GivenNames" hint="이름 / Given Names"></TextField>
                <TextField id="info" v-model="Nationality" hint="국적 / Nationality"></TextField>
                <TextField id="info" v-model="Bdate" hint="생년월일 / Date of birth"></TextField>
                <TextField id="info" v-model="Sex" hint="성별 / Sex"></TextField>
                <TextField id="info" v-model="Idate" hint="발급일 / Date of issue"></TextField>
                <TextField id="info" v-model="Edate" hint="만료일 / Date of expiry"></TextField>
                <TextField id="info" v-model="PersonalNo" hint="주민등록번호 뒷자리 / Personal No."></TextField>
                <Button id="submit" text="확인"></Button>
            </FlexboxLayout>
        </FlexboxLayout>
    </Page>
</template>
<script>
export default {
    data(){
        return {
            Passport : {
                Type:"",
                PassportNo:"",
                Surname:"",
                GivenNames:"",
                Nationality:"",
                Bdate:"",
                Sex:"",
                Idate:"",
                Edate:"",
                PersonalNo:"",
            }
        }
    }
}
</script>
<style scoped>

</style>