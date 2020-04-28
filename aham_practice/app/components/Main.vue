<template>
  <Page>
    <FlexboxLayout flexDirection="column">
        <Label text="AHAM LOGO will be here" />
        <TextView editable="false" height="400">
            <FormattedString>
                <Span
                text="This is information of Aham"
                />
                <Span text="bold, " fontWeight="Bold" />
                <Span text="italic " fontStyle="Italic" />
                <Span text="and " />
                <Span text="underline." textDecoration="Underline" />
            </FormattedString>
        </TextView>
        <FlexboxLayout flexDirection="column">
            <Button text="시작하기" @tap="getStartApp"/>

            <FlexboxLayout>
                <Button text="약관 및 동의" @tap="getInfo" />
                <Button text="복구하기" @tap="getRestore"/>
            </FlexboxLayout>

        </FlexboxLayout>
    </FlexboxLayout>
  </Page>
</template>

<script>
import AnotherPage from './AnotherPage'

export default {
    
    methods : {
        getStartApp() {
                this.textFieldValue = "Button was pressed !";
                this.$navigateTo(AnotherPage);
            },
        getInfo() {
            console.log("get information");
        },
        getRestore() {
            console.log("will restore information");
        }
    }

};
</script>

<style scoped>
    FlexboxLayout {
        justify-content: center;
    }
</style>