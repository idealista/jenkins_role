def testJob = freeStyleJob("basic")

testJob.with {
  steps {
    shell('echo \"hello\"')
  }
}
