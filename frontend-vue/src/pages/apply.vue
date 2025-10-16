<template>
  <v-container class="py-10">
    <v-card class="mx-auto" max-width="700">
      <v-card-title class="text-center text-h6 font-weight-bold">
        Apply to be a...
      </v-card-title>

      <!-- Tabs -->
      <v-tabs v-model="tab" bg-color="#059669" dark>
        <v-tab value="student">Student</v-tab>
        <v-tab value="teacher">Teacher</v-tab>
      </v-tabs>

      <!-- Tab Content -->
      <v-window v-model="tab" class="pa-6">
        <!-- Student Form -->
        <v-window-item value="student">
          <v-form @submit.prevent="submitStudent">
            <v-row dense>
              <v-col cols="12" md="6">
                <v-text-field v-model="student.firstName" label="First Name" required />
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field v-model="student.lastName" label="Last Name" required />
              </v-col>

              <v-col cols="12" md="6">
                <v-text-field v-model="student.doB" label="Date of Birth" type="date" />
              </v-col>
              <v-col cols="12" md="6">
                <v-select
                  v-model="student.gender"
                  :items="['Male', 'Female', 'Other']"
                  label="Gender"
                />
              </v-col>

              <v-col cols="12">
                <v-text-field v-model="student.homeAddress" label="Home Address" />
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field v-model="student.email" label="Email" type="email" />
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field v-model="student.phoneNo" label="Phone Number" />
              </v-col>

              <v-col cols="12">
                <v-textarea v-model="student.applicationInfo" label="Application Info" />
              </v-col>
              <v-col cols="12">
                <v-textarea v-model="student.medicalInfo" label="Medical Info" />
              </v-col>

              <v-col cols="12" md="6">
                <v-text-field
                  v-model="student.relationshipWith"
                  label="Relationship With"
                />
              </v-col>
            </v-row>

            <v-btn block class="mt-4" color="#059669" type="submit">Submit Student</v-btn>
          </v-form>
        </v-window-item>

        <!-- Teacher Form -->
        <v-window-item value="teacher">
          <v-form @submit.prevent="submitTeacher">
            <v-row dense>
              <v-col cols="12" md="6">
                <v-text-field v-model="teacher.firstName" label="First Name" required />
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field v-model="teacher.lastName" label="Last Name" required />
              </v-col>

              <v-col cols="12" md="6">
                <v-text-field v-model="teacher.doB" label="Date of Birth" type="date" />
              </v-col>
              <v-col cols="12" md="6">
                <v-select
                  v-model="teacher.gender"
                  :items="['Male', 'Female', 'Other']"
                  label="Gender"
                />
              </v-col>

              <v-col cols="12">
                <v-text-field v-model="teacher.homeAddress" label="Home Address" />
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field v-model="teacher.email" label="Email" type="email" />
              </v-col>
              <v-col cols="12" md="6">
                <v-text-field v-model="teacher.phoneNo" label="Phone Number" />
              </v-col>

              <v-col cols="12">
                <v-textarea v-model="teacher.applicationInfo" label="Application Info" />
              </v-col>
              <v-col cols="12">
                <v-textarea v-model="teacher.medicalInfo" label="Medical Info" />
              </v-col>
            </v-row>

            <v-btn block class="mt-4" color="#059669" type="submit">Submit Teacher</v-btn>
          </v-form>
        </v-window-item>
      </v-window>
    </v-card>
  </v-container>
</template>

<script setup lang="ts">
  import { ref } from 'vue'

  // Default tab
  const tab = ref('student')

  // Common structure for Person
  const student = ref({
    personID: null,
    firstName: '',
    lastName: '',
    doB: '',
    gender: '',
    homeAddress: '',
    email: '',
    phoneNo: '',
    applicationInfo: '',
    typeOfPerson: 'Student',
    medicalInfo: '',
    userFlag: true,
    relationshipWith: '',
    debt: 0,
  })

  const teacher = ref({
    personID: null,
    firstName: '',
    lastName: '',
    doB: '',
    gender: '',
    homeAddress: '',
    email: '',
    phoneNo: '',
    applicationInfo: '',
    typeOfPerson: 'Teacher',
    medicalInfo: '',
    userFlag: true,
    relationshipWith: '',
    salary: 0,
    hireDate: null,
  })

  // Submit handlers
  function submitStudent () {
    console.log('Student submitted:', student.value)
  }

  function submitTeacher () {
    console.log('Teacher submitted:', teacher.value)
  }
</script>
