<template>
    <Page>
        <ActionBar title="Home" />
        <ScrollView>
            <StackLayout class="home-panel">
                <!--Add your page content here-->

                <ListView for="country in countries" @itemTap="onItemTap"
                    style="height:1250px">
                    <v-template>
                        <FlexboxLayout flexDirection="row">
                            <Image :src="country.imageSrc"
                                class="thumb img-circle" />
                            <Label :text="country.name" class="t-12"
                                style="width: 60%" />
                        </FlexboxLayout>
                    </v-template>
                </ListView>

                <Label textWrap="true" :text="this.textFieldValue"
                    class="h2 description-label" />
                <TextField v-model="textFieldValue" hint="Enter text..." />
                <Button class="button" text="Button" @tap="onButtonTap" />
            </StackLayout>
        </ScrollView>
    </Page>
</template>

<script>
import AnotherPage from './AnotherPage'
    
    export default {
        methods: {
            onItemTap: function(args) {
                console.log("Item with index: " + args.index + " tapped");
            },

            onButtonTap() {
                this.textFieldValue = "Button was pressed !";
                this.$navigateTo(AnotherPage);
            }
        },

        mounted() {
            console.log("Hi there");
        },
        data() {
            return {
                
                countries: [{
                        name: "Australia",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/au.png"
                    },
                    {
                        name: "Belgium",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/be.png"
                    },
                    {
                        name: "Bulgaria",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/bg.png"
                    },
                    {
                        name: "Canada",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/ca.png"
                    },
                    {
                        name: "Switzerland",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/ch.png"
                    },
                    {
                        name: "China",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/cn.png"
                    },
                    {
                        name: "Czech Republic",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/cz.png"
                    },
                    {
                        name: "Germany",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/de.png"
                    },
                    {
                        name: "Spain",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/es.png"
                    },
                    {
                        name: "Ethiopia",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/et.png"
                    },
                    {
                        name: "Croatia",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/hr.png"
                    },
                    {
                        name: "Hungary",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/hu.png"
                    },
                    {
                        name: "Italy",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/it.png"
                    },
                    {
                        name: "Jamaica",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/jm.png"
                    },
                    {
                        name: "Romania",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/ro.png"
                    },
                    {
                        name: "Russia",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/ru.png"
                    },
                    {
                        name: "United States",
                        imageSrc: "https://play.nativescript.org/dist/assets/img/flags/us.png"
                    }
                ],

                textFieldValue: ""
            };
        }
    };
</script>

<style scoped>
    .home-panel {
        vertical-align: center;
        font-size: 20;
        margin: 15;
    }

    .description-label {
        margin-bottom: 15;
    }
</style>