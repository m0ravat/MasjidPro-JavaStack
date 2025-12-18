// Utilities
import { defineStore } from 'pinia'
import { gql } from '@apollo/client'
import { apollo } from './apollo.ts'
import { ref } from 'vue'

interface Event {
  eventID: number
  title: string
  shortDesc: string
  dateInfo: string
  timeInfo: string
  openTo: string
  eventDesc: string
  relevantLinks: string
  image: string
  location: string
}

export const useEventStore = defineStore('event', () => {
  const events = ref<Event[]>([])
  const loading = ref(false)
  const error = ref<string | null>(null)

  const fetchEvents = async () => {
    loading.value = true
    error.value = null

    try {
      const query = gql`
        query {
          publicEvents {
            eventID
            title
            shortDesc
            dateInfo
            timeInfo
            openTo
            eventDesc
            relevantLinks
            image
            location
          }
        }
      `

      const res = await apollo.query({ query }) as {
        data: { publicEvents: Event[] }
      }

      events.value = res.data.publicEvents

    } catch (err: any) {
      error.value = err.message
    } finally {
      loading.value = false
    }
  }

  return { events, loading, error, fetchEvents }
})


interface Course {
  courseName: string
  courseDesc: string
  Image: string
  targetAge: string
  summary: string
  duration: string
  price: string
}

export const useCourseStore = defineStore('course', () => {
  const courses = ref<Course[]>([])
  const loading = ref(false)
  const error = ref<string | null>(null)

  const fetchCourses = async () => {
    loading.value = true
    error.value = null

    try {
      const query = gql`
        query {
          courses {
            courseName
            courseDesc
            summary
            Image
            targetAge
            duration
            price

          }
        }
      `

      const res = await apollo.query({ query }) as {
        data: { courses: Course[] }
      }

      courses.value = res.data.courses

    } catch (err: any) {
      error.value = err.message
    } finally {
      loading.value = false
    }
  }

  return { courses, loading, error, fetchCourses }
})
