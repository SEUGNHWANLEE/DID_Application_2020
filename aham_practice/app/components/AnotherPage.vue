<template>
    <Page>
    <ActionBar title="Another" />
    <StackLayout>
        <Label text="Here is another page !" />
        <Button text="Back" @tap="onButtonTap" />
    </StackLayout>
    </Page>
</template>

<script>
    export default {
        methods: {
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