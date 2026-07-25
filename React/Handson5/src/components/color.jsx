import styles from "./color.module.css";

function CohortDetails(props) {
  const cohort = props.cohort;

  return (
    <div className={styles.box}>
      <h2>{cohort.name}</h2>

      <h3
        style={{
          color:
            cohort.currentStatus.toLowerCase() === "ongoing"
              ? "green"
              : "blue",
        }}
      >
        {cohort.currentStatus}
      </h3>

      <dl>
        <dt>Mentor</dt>
        <dd>{cohort.mentor}</dd>

        <dt>Coach</dt>
        <dd>{cohort.coach}</dd>

        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>

        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;