<template>
    <Page>
    <ActionBar title="핀 비밀번호 설정" />
    <StackLayout>
        <Label text="Logo is here ! " />
         <TextField secure="false" hint="password" />
         <Span text="핀 번호 입력" fontWeight="Bold" />
        <Button text="뒤로가기" @tap="onBackButton"/>
        <Button text="6자리 입력" @tap="getPassword" />
    </StackLayout>
    </Page>
</template>

<script>
import PasswordPages from './PasswordPages'
import IdentificationPage from './IdentificationPage'
    export default {
        methods: {
            onBackButton() {
                this.$navigateBack();
            },
            
            getPassword() {
                this.$navigateTo(IdentificationPage);
                //this.$navigateTo(PasswordPages);
            }
        }
    };
</script>

<style>
</style>