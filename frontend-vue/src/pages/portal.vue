<template>
  <div class="bg-grey-lighten-4">
    <v-container class="py-16">
      <h1 class="text-h3 text-center font-weight-bold mb-2">
        Welcome to our Mosque Learning Platform!
      </h1>
      <p class="text-center mb-12">
        Here you can make an application to join us or login if you have an account set up already.
      </p>

      <h2 class="text-center mb-8">User Portals</h2>
      <v-row justify="center">
        <v-col
          v-for="portal in portals"
          :key="portal.type"
          cols="12"
          md="4"
        >
          <v-card class="pa-6 text-center" elevation="2" rounded="lg">
            <v-avatar class="mb-6" color="green-lighten-4" size="80">
              <v-icon color="green-darken-2" size="40">
                {{ portal.icon }}
              </v-icon>
            </v-avatar>

            <h2 class="text-h5 font-weight-bold mb-4">
              {{ portal.title }}
            </h2>

            <p class="text-body-1 text-grey-darken-1 mb-6">
              {{ portal.description }}
            </p>

            <v-btn
              block
              color="green-darken-1"
              rounded="lg"
              size="large"
              @click="openLoginModal(portal.type)"
            >
              Sign In to Portal
            </v-btn>
          </v-card>
        </v-col>
      </v-row>

      <h2 class="my-6 text-center">Join us!</h2>
      <v-row justify="center">
        <v-col cols="12">
          <v-card
            class="pa-6 text-center"
            elevation="2"
            rounded="lg"
            to="/apply"
          >
            <v-avatar class="mb-6" color="green-lighten-4" size="80">
              <v-icon color="green-darken-2" size="40">mdi-pen</v-icon>
            </v-avatar>

            <h2 class="text-h5 font-weight-bold mb-4">Apply here!</h2>

            <p class="text-body-1 text-grey-darken-1 mb-6">
              Join us by becoming a teacher or student!
            </p>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- Login Modal -->
    <v-dialog v-model="loginDialog" max-width="500">
      <v-card>
        <v-card-title class="text-h5 font-weight-bold pa-6">
          {{ selectedPortalTitle }} Login
        </v-card-title>

        <v-card-text class="px-6 pb-0">
          <v-form ref="loginForm">
            <v-text-field
              v-model="username"
              class="mb-4"
              label="Username"
              prepend-inner-icon="mdi-account"
              :rules="[rules.required]"
              variant="outlined"
            />

            <v-text-field
              v-model="password"
              label="Password"
              prepend-inner-icon="mdi-lock"
              :rules="[rules.required]"
              type="password"
              variant="outlined"
            />
          </v-form>
        </v-card-text>

        <v-card-actions class="px-6 pb-6">
          <v-spacer />
          <v-btn color="grey" variant="text" @click="closeLoginModal">
            Cancel
          </v-btn>
          <v-btn color="green-darken-1" variant="flat" @click="handleLogin">
            Sign In
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import type { VForm } from 'vuetify/components'

/* =====================
   Types
===================== */
type PortalType = 'student' | 'parent' | 'teacher'

interface Portal {
  type: PortalType
  title: string
  description: string
  icon: string
}

/* =====================
   Data
===================== */
const portals: Portal[] = [
  {
    type: 'student',
    title: 'Student Portal',
    description: 'Access your courses, assignments, and progress',
    icon: 'mdi-school',
  },
  {
    type: 'parent',
    title: 'Parent Portal',
    description: "Monitor your child's progress and communicate with teachers",
    icon: 'mdi-account-multiple',
  },
  {
    type: 'teacher',
    title: 'Teacher Portal',
    description: 'Manage classes, students, and curriculum',
    icon: 'mdi-book-open-page-variant',
  },
]

const loginDialog = ref(false)
const selectedPortal = ref<PortalType | ''>('')
const selectedPortalTitle = ref('')
const username = ref('')
const password = ref('')
const loginForm = ref<VForm | null>(null)

/* =====================
   Validation Rules
===================== */
const rules = {
  required: (value: string) => !!value || 'This field is required',
}

/* =====================
   Methods
===================== */
function openLoginModal(portalType: PortalType) {
  selectedPortal.value = portalType

  const portal = portals.find(p => p.type === portalType)
  selectedPortalTitle.value = portal ? portal.title : ''

  loginDialog.value = true
}

function closeLoginModal() {
  loginDialog.value = false
  username.value = ''
  password.value = ''

  loginForm.value?.reset()
}

async function handleLogin() {
  if (!loginForm.value) return

  const { valid } = await loginForm.value.validate()

  if (!valid) return

  console.log('Login attempt:', {
    portal: selectedPortal.value,
    username: username.value,
    password: password.value,
  })

  alert(`Logging into ${selectedPortalTitle.value} as ${username.value}`)
  closeLoginModal()
}
</script>
