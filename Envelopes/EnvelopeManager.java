public class EnvelopeManager {

    private HashMap<Envelope, UUID> envelopes;
    private HashMap<UUID, Envelope> uuids;

    private static EnvelopeManager envelopeManager = null;

    private EnvelopeManager() {
       envelopeManager = EnvelopeManager.getInstance();
       envelopeManager.envelopes = new HashMap<>();
    }

    public static synchronized EnvelopeManager getInstance() {
        if (envelopeManager == null) {
            envelopeManager = new EnvelopeManager();
        }
        return envelopeManager;
    }

    public void makeEnvelope(String name, int balance) {
        Envelope envelope = new Envelope(name, balance);
        envelopes.add(envelope, envelope.getUUID());
    }

    // assign priority constructor

    public Envelope getEnvelope(UUID id) {
        return uuids.get(id);
    }

    public UUID deleteEnvelope(Envelope envelope) {
        uuids.remove(envelope.getUUID());
        envelopes.remove(envelope);
    }
}
