<template>
    <Page>
    <ActionBar title="Another" />
    <StackLayout>
        <Label text="Here is another page !" />

       
        <StackLayout orientation ="horizontal">
        <Button text="뒤로가기" backgroundColor="#43b883" color="white" @tap="onButtonTap"/>
        <Button text="계속하기" backgroundColor="#43b883" color="white" @tap="onButtonGo" />
        </StackLayout>
    </StackLayout>
    </Page>
</template>

<script>
import PasswordPage from './PasswordPage'
    export default {
        methods: {
            onButtonGo() {
                this.textFieldValue = "Button was pressed !";
                this.$navigateTo(PasswordPage);
            },
            onButtonTap() {
                console.log("Back Button was pressed");
                this.$navigateBack();
            }
        },
        data() {
            return {};
        }
    };
</script>

<style>
</style>