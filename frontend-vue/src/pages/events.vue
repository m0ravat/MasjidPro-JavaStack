<template>
  <div class="bg-grey-lighten-4">
    <v-container class="py-12">
      <!-- Decorative line and heading -->
      <div class="mb-8">
        <div class="bg-emerald-600" style="width: 180px; height: 4px; margin-bottom: 24px;" />
        <h1 class="text-h3 font-weight-bold">Upcoming Events</h1>
      </div>

      <!-- Events Grid -->
      <v-row>
        <v-col
          v-for="event in eventStore.events"
          :key="event.eventID"
          cols="12"
          md="6"
        >
          <v-card
            class="h-100 d-flex flex-column"
            elevation="2"
            hover
            :to="`/events/${event.eventID}`"
          >
            <!-- Event Image -->
            <v-img
              class="bg-grey-lighten-2"
              cover
              height="300"
              :src="event.image"
            />

            <!-- Event Content -->
            <v-card-text class="flex-grow-1 d-flex flex-column pa-6">
              <!-- Date Badge -->
              <v-chip
                class="mb-4"
                color="black"
                size="small"
                style="width: fit-content;"
                text-color="white"
              >
                {{ event.dateInfo }}
              </v-chip>

              <!-- Event Title -->
              <h2 class="text-h5 font-weight-bold mb-3">
                {{ event.title }}
              </h2>

              <!-- Short Description -->
              <p class="text-body-1 mb-4">
                {{ event.shortDesc }}
              </p>

              <!-- More Info Link -->
              <v-btn
                class="px-0 justify-start"
                color="emerald-600"
                style="text-transform: none;"
                variant="text"
              >
                More Info
                <v-icon end>mdi-arrow-right</v-icon>
              </v-btn>
            </v-card-text>

            <!-- Event Info Footer -->
            <v-divider />
            <v-card-text class="pa-0">
              <v-row class="text-center" no-gutters>
                <v-col class="pa-4 border-e" cols="4">
                  <div class="text-caption text-grey-darken-1 mb-1">Time</div>
                  <div class="font-weight-bold">{{ event.timeInfo }}</div>
                </v-col>
                <v-col class="pa-4 border-e" cols="4">
                  <div class="text-caption text-grey-darken-1 mb-1">Open To</div>
                  <div class="font-weight-bold">{{ event.openTo }}</div>
                </v-col>
                <v-col class="pa-4" cols="4">
                  <div class="text-caption text-grey-darken-1 mb-1">Location</div>
                  <div class="font-weight-bold">{{ event.location }}</div>
                </v-col>
              </v-row>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script lang="ts" setup>
import {useEventStore} from "@/stores/app.ts";
const eventStore = useEventStore();
if (eventStore.events.length === 0) {
  eventStore.fetchEvents?.() // depends on your store
}
</script>

<style scoped>
.bg-emerald-600 {
  background-color: #059669;
}

.text-emerald-600 {
  color: #059669;
}

.border-e {
  border-right: 1px solid rgba(0, 0, 0, 0.12);
}
</style>
