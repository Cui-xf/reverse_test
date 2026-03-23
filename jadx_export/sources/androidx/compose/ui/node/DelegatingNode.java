package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DelegatingNode.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0004¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0001¢\u0006\u0004\b\u0012\u0010\u0010J\"\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0016H\u0080\b¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0014H\u0010¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0001H\u0010¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000eH\u0004J\u0015\u0010'\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000eH\u0001¢\u0006\u0002\b(J\u0017\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010+H\u0010¢\u0006\u0002\b,J\u0018\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0001H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u00064"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "delegate", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "selfKindSet", "", "getSelfKindSet$ui_release$annotations", "getSelfKindSet$ui_release", "()I", "T", "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "delegateUnprotected", "delegateUnprotected$ui_release", "forEachImmediateDelegate", "", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui_release", "markAsAttached", "markAsAttached$ui_release", "markAsDetached", "markAsDetached$ui_release", "reset", "reset$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "undelegate", "instance", "undelegateUnprotected", "undelegateUnprotected$ui_release", "updateCoordinator", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    public static /* synthetic */ void getSelfKindSet$ui_release$annotations() {
    }

    /* renamed from: getSelfKindSet$ui_release, reason: from getter */
    public final int getSelfKindSet() {
        return this.selfKindSet;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(NodeCoordinator coordinator) {
        super.updateCoordinator$ui_release(coordinator);
        for (Modifier.Node node$iv = getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.updateCoordinator$ui_release(coordinator);
        }
    }

    /* renamed from: getDelegate$ui_release, reason: from getter */
    public final Modifier.Node getDelegate() {
        return this.delegate;
    }

    public final void setDelegate$ui_release(Modifier.Node node) {
        this.delegate = node;
    }

    public final <T extends DelegatableNode> T delegateUnprotected$ui_release(T delegatableNode) {
        return (T) delegate(delegatableNode);
    }

    public final void undelegateUnprotected$ui_release(DelegatableNode instance) {
        undelegate(instance);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void setAsDelegateTo$ui_release(Modifier.Node owner) {
        super.setAsDelegateTo$ui_release(owner);
        for (Modifier.Node node$iv = getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.setAsDelegateTo$ui_release(owner);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final <T extends androidx.compose.ui.node.DelegatableNode> T delegate(T r13) {
        /*
            r12 = this;
            androidx.compose.ui.Modifier$Node r0 = r13.getNode()
            r1 = 1
            r2 = 0
            if (r0 == r13) goto La
            r3 = 1
            goto Lb
        La:
            r3 = 0
        Lb:
            r4 = 0
            if (r3 == 0) goto L3a
            boolean r5 = r13 instanceof androidx.compose.ui.Modifier.Node
            if (r5 == 0) goto L16
            r5 = r13
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            goto L17
        L16:
            r5 = r4
        L17:
            if (r5 == 0) goto L1d
            androidx.compose.ui.Modifier$Node r4 = r5.getParent()
        L1d:
            androidx.compose.ui.Modifier$Node r5 = r12.getNode()
            if (r0 != r5) goto L2a
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r12)
            if (r5 == 0) goto L2a
            goto L2b
        L2a:
            r1 = 0
        L2b:
            if (r1 == 0) goto L2e
            return r13
        L2e:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r5 = "Cannot delegate to an already delegated node"
            java.lang.String r5 = r5.toString()
            r2.<init>(r5)
            throw r2
        L3a:
            boolean r5 = r0.getIsAttached()
            r5 = r5 ^ r1
            r6 = 0
            if (r5 != 0) goto L4a
            r7 = 0
            java.lang.String r7 = "Cannot delegate to an already attached node"
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException(r7)
        L4a:
            androidx.compose.ui.Modifier$Node r5 = r12.getNode()
            r0.setAsDelegateTo$ui_release(r5)
            int r5 = r12.getKindSet()
            int r6 = androidx.compose.ui.node.NodeKindKt.calculateNodeKindSetFromIncludingDelegates(r0)
            r0.setKindSet$ui_release(r6)
            r12.validateDelegateKindSet(r6, r0)
            androidx.compose.ui.Modifier$Node r7 = r12.delegate
            r0.setChild$ui_release(r7)
            r12.delegate = r0
            r7 = r12
            androidx.compose.ui.Modifier$Node r7 = (androidx.compose.ui.Modifier.Node) r7
            r0.setParent$ui_release(r7)
            int r7 = r12.getKindSet()
            r7 = r7 | r6
            r12.updateNodeKindSet(r7, r2)
            boolean r7 = r12.getIsAttached()
            if (r7 == 0) goto Lc3
            r7 = 0
            r8 = 2
            int r7 = androidx.compose.ui.node.NodeKind.m5778constructorimpl(r8)
            r9 = r6
            r10 = 0
            r11 = r9 & r7
            if (r11 == 0) goto L8a
            r7 = 1
            goto L8b
        L8a:
            r7 = 0
        L8b:
            if (r7 == 0) goto Lb3
            r7 = 0
            int r7 = androidx.compose.ui.node.NodeKind.m5778constructorimpl(r8)
            r8 = r5
            r9 = 0
            r10 = r8 & r7
            if (r10 == 0) goto L9a
            goto L9b
        L9a:
            r1 = 0
        L9b:
            if (r1 != 0) goto Lb3
            r1 = r12
            androidx.compose.ui.node.DelegatableNode r1 = (androidx.compose.ui.node.DelegatableNode) r1
            androidx.compose.ui.node.LayoutNode r1 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r1)
            androidx.compose.ui.node.NodeChain r1 = r1.getNodes()
            androidx.compose.ui.Modifier$Node r2 = r12.getNode()
            r2.updateCoordinator$ui_release(r4)
            r1.syncCoordinators()
            goto Lba
        Lb3:
            androidx.compose.ui.node.NodeCoordinator r1 = r12.getCoordinator()
            r12.updateCoordinator$ui_release(r1)
        Lba:
            r0.markAsAttached$ui_release()
            r0.runAttachLifecycle$ui_release()
            androidx.compose.ui.node.NodeKindKt.autoInvalidateInsertedNode(r0)
        Lc3:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatingNode.delegate(androidx.compose.ui.node.DelegatableNode):androidx.compose.ui.node.DelegatableNode");
    }

    protected final void undelegate(DelegatableNode instance) {
        Modifier.Node prev = null;
        Modifier.Node it = this.delegate;
        boolean found = false;
        while (true) {
            if (it == null) {
                break;
            }
            if (it == instance) {
                if (it.getIsAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(it);
                    it.runDetachLifecycle$ui_release();
                    it.markAsDetached$ui_release();
                }
                it.setAsDelegateTo$ui_release(it);
                it.setAggregateChildKindSet$ui_release(0);
                if (prev == null) {
                    this.delegate = it.getChild();
                } else {
                    prev.setChild$ui_release(it.getChild());
                }
                it.setChild$ui_release(null);
                it.setParent$ui_release(null);
                found = true;
            } else {
                prev = it;
                it = it.getChild();
            }
        }
        if (!found) {
            throw new IllegalStateException(("Could not find delegate: " + instance).toString());
        }
        int beforeKindSet = getKindSet();
        int afterKindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
        updateNodeKindSet(afterKindSet, true);
        if (getIsAttached()) {
            int value$iv = (beforeKindSet & NodeKind.m5778constructorimpl(2)) != 0 ? 1 : 0;
            if (value$iv != 0) {
                if ((afterKindSet & NodeKind.m5778constructorimpl(2)) != 0) {
                    return;
                }
                NodeChain chain = DelegatableNodeKt.requireLayoutNode(this).getNodes();
                getNode().updateCoordinator$ui_release(null);
                chain.syncCoordinators();
            }
        }
    }

    private final void validateDelegateKindSet(int delegateKindSet, Modifier.Node delegateNode) {
        int current = getKindSet();
        int value$iv = (delegateKindSet & NodeKind.m5778constructorimpl(2)) != 0 ? 1 : 0;
        if (value$iv != 0) {
            if ((current & NodeKind.m5778constructorimpl(2)) != 0) {
                boolean value$iv2 = this instanceof LayoutModifierNode;
                if (value$iv2) {
                    return;
                }
                InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + delegateNode);
            }
        }
    }

    private final void updateNodeKindSet(int newKindSet, boolean recalculateOwner) {
        Modifier.Node child;
        int before = getKindSet();
        setKindSet$ui_release(newKindSet);
        if (before != newKindSet) {
            int agg = newKindSet;
            if (DelegatableNodeKt.isDelegationRoot(this)) {
                setAggregateChildKindSet$ui_release(agg);
            }
            if (getIsAttached()) {
                Modifier.Node owner = getNode();
                DelegatingNode it = this;
                while (it != null) {
                    agg |= it.getKindSet();
                    it.setKindSet$ui_release(agg);
                    if (it == owner) {
                        break;
                    } else {
                        it = it.getParent();
                    }
                }
                if (recalculateOwner && it == owner) {
                    agg = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(owner);
                    owner.setKindSet$ui_release(agg);
                }
                int agg2 = agg | ((it == null || (child = it.getChild()) == null) ? 0 : child.getAggregateChildKindSet());
                while (it != null) {
                    agg2 |= it.getKindSet();
                    it.setAggregateChildKindSet$ui_release(agg2);
                    it = it.getParent();
                }
            }
        }
    }

    public final void forEachImmediateDelegate$ui_release(Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node node = getDelegate(); node != null; node = node.getChild()) {
            block.invoke(node);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node node$iv = getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.updateCoordinator$ui_release(getCoordinator());
            if (!it.getIsAttached()) {
                it.markAsAttached$ui_release();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node node$iv = getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node node$iv = getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.runDetachLifecycle$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui_release() {
        for (Modifier.Node node$iv = getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node node$iv = getDelegate(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            it.reset$ui_release();
        }
    }
}
