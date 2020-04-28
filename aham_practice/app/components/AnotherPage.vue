<template>
  <Page>
    <ActionBar title="Another" />
    <StackLayout>
      <Label text="Here is another page !" />
      <StackLayout orientation="horizontal">
        <Button text="뒤로가기" backgroundColor="#43b883" color="white" @tap="onButtonTap" />
        <Button @tap="onButtonGo" text="계속하기" backgroundColor="#43b883" color="white" />
      </StackLayout>
    </StackLayout>
  </Page>
</template>

<script>
import PasswordPage from "./PasswordPage";

export default {
  methods: {
    onButtonGo() {
      console.log("to the password page");
      this.$navigateTo(this.pass);
    },
    onButtonTap() {
      console.log("Back Button was pressed");
      this.$navigateBack();
    }
  },
  data() {
    return {
        pass : PasswordPage
    };
  }
};
</script>

<style>
</style>