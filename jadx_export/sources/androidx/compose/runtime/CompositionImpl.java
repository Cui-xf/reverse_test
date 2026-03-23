package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composition.kt */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002¥\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010X\u001a\u00020\u001aH\u0016J\u0018\u0010Y\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020\u0013H\u0002J\u001e\u0010Y\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010[\u001a\u00020\u0013H\u0002J\b\u0010]\u001a\u00020\u001aH\u0016J\u0010\u0010^\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010_\u001a\u00020\u001aH\u0016J\b\u0010`\u001a\u00020\u001aH\u0016J\b\u0010a\u001a\u00020\u001aH\u0002J \u0010b\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ \u0010d\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0002¢\u0006\u0002\u0010\u001fJ\r\u0010e\u001a\u00020:H\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020\u001aH\u0016J3\u0010h\u001a\u0002Hi\"\u0004\b\u0000\u0010i2\b\u0010j\u001a\u0004\u0018\u00010\u00012\u0006\u0010k\u001a\u00020:2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hi0\u0019H\u0016¢\u0006\u0002\u0010mJ\b\u0010n\u001a\u00020\u001aH\u0016J\u0010\u0010o\u001a\u00020\u001a2\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010r\u001a\u00020\u001aH\u0002J\b\u0010s\u001a\u00020\u001aH\u0002J#\u0010t\u001a\u0004\u0018\u0001Hu\"\u0004\b\u0000\u0010u2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Hu0wH\u0016¢\u0006\u0002\u0010xJ\"\u0010y\u001a\u0002Hu\"\u0004\b\u0000\u0010u2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hu0\u0019H\u0082\b¢\u0006\u0002\u0010zJC\u0010{\u001a\u0002Hu\"\u0004\b\u0000\u0010u2-\u0010l\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00¢\u0006\f\b}\u0012\b\b~\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002Hu0|H\u0082\b¢\u0006\u0002\u0010\u007fJ)\u0010\u0080\u0001\u001a\u00020\u001a2\u001e\u0010\u0081\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0083\u00010\u0082\u00010$H\u0016J\u001e\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020%2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u001aH\u0016J(\u0010\u0089\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020%2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0002J\u000f\u0010\u008c\u0001\u001a\u00020\u001a2\u0006\u0010v\u001a\u00020:J\u0011\u0010\u008d\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0002J\u001a\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0000¢\u0006\u0003\b\u0092\u0001J\f\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0002J\u0017\u0010\u0093\u0001\u001a\u00020\u00132\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0017\u0010\u0094\u0001\u001a\u00020\u001a2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020\u001a2\u0007\u0010\u0086\u0001\u001a\u00020%H\u0016J\u0017\u0010\u0097\u0001\u001a\u00020\u001a2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0011\u0010\u0098\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u0011\u0010\u0099\u0001\u001a\u00020\u001a2\u0006\u0010Z\u001a\u00020,H\u0016J\u001b\u0010\u009a\u0001\u001a\u00020\u001a2\n\u0010p\u001a\u0006\u0012\u0002\b\u000301H\u0000¢\u0006\u0003\b\u009b\u0001J!\u0010\u009c\u0001\u001a\u00020\u001a2\u0007\u0010\u0087\u0001\u001a\u00020,2\u0007\u0010\u0086\u0001\u001a\u00020%H\u0000¢\u0006\u0003\b\u009d\u0001J!\u0010\u009e\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ!\u0010\u009f\u0001\u001a\u00020\u001a2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u0001\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00H\u0002J#\u0010¡\u0001\u001a\u0002Hu\"\u0004\b\u0000\u0010u2\f\u0010l\u001a\b\u0012\u0004\u0012\u0002Hu0\u0019H\u0082\b¢\u0006\u0002\u0010zJ\u001d\u0010¢\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020%2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010,H\u0002J\u0011\u0010£\u0001\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020TH\u0002J\t\u0010¤\u0001\u001a\u00020\u001aH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\b\u0012\u0006\u0012\u0002\b\u00030100X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0015R\u0014\u00105\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0015R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020%0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,00X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0015R\u0014\u0010=\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0015R\u0011\u0010>\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0015R\u000e\u0010?\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%00X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020,0+8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010.R\u0014\u0010E\u001a\u00020FX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010I\u001a\u00020\u0013X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010\u0011\u001a\u0004\bK\u0010\u0015\"\u0004\bL\u0010MR\"\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010,0Oj\n\u0012\u0006\u0012\u0004\u0018\u00010,`PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010\u0011\u001a\u0004\bV\u0010W¨\u0006¦\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "Landroidx/collection/MutableScatterSet;", "derivedStateDependencies", "", "", "getDerivedStateDependencies$runtime_release", "()Ljava/util/Set;", "derivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidatedScopes", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release$annotations", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "values", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "composeInitial", "composerStacksSizes", "composerStacksSizes$runtime_release", "deactivate", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "getCompositionService", "T", "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "invalidateScopeOfLocked", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observe$runtime_release", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "setContentWithReuse", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<Object, DerivedState<?>> derivedStates;
    private boolean disposed;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private ScopeMap<RecomposeScopeImpl, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final ScopeMap<Object, RecomposeScopeImpl> observations;
    private final ScopeMap<Object, RecomposeScopeImpl> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime_release$annotations() {
    }

    public CompositionImpl(CompositionContext parent, Applier<?> applier, CoroutineContext recomposeContext) {
        this.parent = parent;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        this.abandonSet = new MutableScatterSet(0, 1, null).asMutableSet();
        SlotTable it = new SlotTable();
        if (this.parent.getCollectingCallByInformation$runtime_release()) {
            it.collectCalledByInformation();
        }
        if (this.parent.getCollectingSourceInformation()) {
            it.collectSourceInformation();
        }
        this.slotTable = it;
        this.observations = new ScopeMap<>();
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = new ScopeMap<>();
        this.changes = new ChangeList();
        this.lateChanges = new ChangeList();
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new ScopeMap<>();
        this.observerHolder = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl it2 = new ComposerImpl(this.applier, this.parent, this.slotTable, this.abandonSet, this.changes, this.lateChanges, this);
        this.parent.registerComposer$runtime_release(it2);
        this.composer = it2;
        this._recomposeContext = recomposeContext;
        this.isRoot = this.parent instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3634getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    /* renamed from: getSlotTable$runtime_release, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.getMap().asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.getMap().asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    /* renamed from: getPendingInvalidScopes$runtime_release, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    /* renamed from: getObserverHolder$runtime_release, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    /* renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        composeInitial(content);
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        boolean value$iv = !this.disposed;
        if (!value$iv) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, this.composable);
    }

    public final CompositionObserverHandle observe$runtime_release(final CompositionObserver observer) {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl$observe$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object lock$iv2 = this.this$0.lock;
                CompositionImpl compositionImpl = this.this$0;
                CompositionObserver compositionObserver = observer;
                synchronized (lock$iv2) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                        compositionImpl.getObserverHolder().setObserver(null);
                        compositionImpl.getObserverHolder().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invalidateGroupsWithKey(int r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.Object r2 = r1.lock
            r3 = 0
            monitor-enter(r2)
            r0 = 0
            androidx.compose.runtime.SlotTable r4 = r1.slotTable     // Catch: java.lang.Throwable -> L5d
            r5 = r17
            java.util.List r4 = r4.invalidateGroupsWithKey$runtime_release(r5)     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r2)
            if (r4 == 0) goto L46
            r2 = r4
            r3 = 0
            r6 = r2
            r7 = 0
            r8 = 0
            int r9 = r6.size()
        L1e:
            if (r8 >= r9) goto L3f
            java.lang.Object r11 = r6.get(r8)
            r12 = r11
            r13 = 0
            r14 = r12
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14
            r15 = 0
            r0 = 0
            androidx.compose.runtime.InvalidationResult r0 = r14.invalidateForResult(r0)
            androidx.compose.runtime.InvalidationResult r10 = androidx.compose.runtime.InvalidationResult.IGNORED
            if (r0 != r10) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 == 0) goto L3a
            r0 = 1
            goto L41
        L3a:
            int r8 = r8 + 1
            goto L1e
        L3f:
            r0 = 0
        L41:
            if (r0 == 0) goto L44
            goto L46
        L44:
            r0 = 0
            goto L47
        L46:
            r0 = 1
        L47:
            if (r0 == 0) goto L5a
            androidx.compose.runtime.ComposerImpl r2 = r1.composer
            boolean r2 = r2.forceRecomposeScopes$runtime_release()
            if (r2 == 0) goto L5a
            androidx.compose.runtime.CompositionContext r2 = r1.parent
            r3 = r1
            androidx.compose.runtime.ControlledComposition r3 = (androidx.compose.runtime.ControlledComposition) r3
            r2.invalidate$runtime_release(r3)
        L5a:
            return
        L5b:
            r0 = move-exception
            goto L60
        L5d:
            r0 = move-exception
            r5 = r17
        L60:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateGroupsWithKey(int):void");
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object toRecord = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (toRecord != null) {
            if (Intrinsics.areEqual(toRecord, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (toRecord instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) toRecord, true);
                return;
            }
            if (!(toRecord instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked((Set<? extends Object>) changed, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object toRecord = this.pendingModifications.getAndSet(null);
        if (!Intrinsics.areEqual(toRecord, CompositionKt.PendingApplyNoModifications)) {
            if (toRecord instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) toRecord, false);
                return;
            }
            if (!(toRecord instanceof Object[])) {
                if (toRecord == null) {
                    ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                    throw new KotlinNothingValueException();
                }
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set changed : (Set[]) toRecord) {
                addPendingInvalidationsLocked((Set<? extends Object>) changed, false);
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) throws Exception {
        CompositionImpl compositionImpl;
        Map<RecomposeScopeImpl, Set<Object>> mapAsMap;
        try {
            Object lock$iv = this.lock;
            synchronized (lock$iv) {
                try {
                    try {
                        drainPendingModificationsForCompositionLocked();
                        ScopeMap invalidations$iv = takeInvalidations();
                        try {
                            try {
                                CompositionObserver observer = observer();
                                if (observer != null) {
                                    try {
                                        compositionImpl = this;
                                        try {
                                            mapAsMap = invalidations$iv.asMap();
                                        } catch (Exception e) {
                                            e$iv = e;
                                            this.invalidations = invalidations$iv;
                                            throw e$iv;
                                        } catch (Throwable th) {
                                            e$iv = th;
                                            throw e$iv;
                                        }
                                    } catch (Exception e2) {
                                        e$iv = e2;
                                    } catch (Throwable th2) {
                                        e$iv = th2;
                                    }
                                    try {
                                        Intrinsics.checkNotNull(mapAsMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                                        observer.onBeginComposition(compositionImpl, mapAsMap);
                                    } catch (Exception e3) {
                                        e$iv = e3;
                                        this.invalidations = invalidations$iv;
                                        throw e$iv;
                                    } catch (Throwable th3) {
                                        e$iv = th3;
                                        throw e$iv;
                                    }
                                }
                                try {
                                    this.composer.composeContent$runtime_release(invalidations$iv, content);
                                    if (observer != null) {
                                        observer.onEndComposition(this);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                } catch (Exception e4) {
                                    e$iv = e4;
                                    this.invalidations = invalidations$iv;
                                    throw e$iv;
                                }
                            } catch (Exception e5) {
                                e$iv = e5;
                            }
                        } catch (Throwable th4) {
                            e$iv = th4;
                        }
                    } catch (Throwable th5) {
                        e$iv = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (0 == 0) {
                        try {
                            if (!this.abandonSet.isEmpty()) {
                                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                            }
                        } catch (Exception e$iv) {
                            abandonChanges();
                            throw e$iv;
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            boolean nonEmptySlotTable = true;
            boolean value$iv = !this.composer.getIsComposing();
            if (!value$iv) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            boolean value$iv2 = this.disposed;
            if (!value$iv2) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m3635getLambda2$runtime_release();
                ChangeList deferredChanges = this.composer.getDeferredChanges();
                if (deferredChanges != null) {
                    applyChangesInLocked(deferredChanges);
                }
                if (this.slotTable.getGroupsSize() <= 0) {
                    nonEmptySlotTable = false;
                }
                if (nonEmptySlotTable || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
                    if (nonEmptySlotTable) {
                        this.applier.onBeginChanges();
                        SlotTable this_$iv = this.slotTable;
                        SlotWriter writer$iv = this_$iv.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(writer$iv, manager);
                            Unit unit = Unit.INSTANCE;
                            writer$iv.close(true);
                            this.applier.clear();
                            this.applier.onEndChanges();
                            manager.dispatchRememberObservers();
                        } catch (Throwable th) {
                            writer$iv.close(false);
                            throw th;
                        }
                    }
                    manager.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.Set[]] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Set<? extends Object> setPlus;
        do {
            obj = this.pendingModifications.get();
            if (obj == null ? true : Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                setPlus = values;
            } else if (obj instanceof Set) {
                setPlus = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                setPlus = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, setPlus));
        if (obj != null) {
            return;
        }
        synchronized (this.lock) {
            drainPendingModificationsLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
    
        return true;
     */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r25) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime_release(block);
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        int j$iv$iv$iv;
        char c;
        ScopeMap this_$iv = this.observations;
        int $i$f$forEachScopeOf = 0;
        Object value$iv = this_$iv.getMap().get(value);
        if (value$iv == null) {
            return;
        }
        if (!(value$iv instanceof MutableScatterSet)) {
            RecomposeScopeImpl scope = (RecomposeScopeImpl) value$iv;
            if (!this.observationsProcessed.remove(value, scope) && scope.invalidateForResult(value) != InvalidationResult.IGNORED) {
                if (scope.isConditional() && !forgetConditionalScopes) {
                    this.conditionallyInvalidatedScopes.add(scope);
                    return;
                } else {
                    this.invalidatedScopes.add(scope);
                    return;
                }
            }
            return;
        }
        ScatterSet this_$iv$iv = (MutableScatterSet) value$iv;
        Object[] k$iv$iv = this_$iv$iv.elements;
        long[] m$iv$iv$iv = this_$iv$iv.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
        int i$iv$iv$iv = 0;
        if (0 > lastIndex$iv$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
            ScopeMap this_$iv2 = this_$iv;
            int $i$f$forEachScopeOf2 = $i$f$forEachScopeOf;
            Object value$iv2 = value$iv;
            ScatterSet this_$iv$iv2 = this_$iv$iv;
            long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                int j$iv$iv$iv2 = 0;
                while (j$iv$iv$iv2 < bitCount$iv$iv$iv) {
                    long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                    if (!(value$iv$iv$iv$iv < 128)) {
                        j$iv$iv$iv = j$iv$iv$iv2;
                        c = '\b';
                    } else {
                        int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv2;
                        c = '\b';
                        RecomposeScopeImpl scope2 = (RecomposeScopeImpl) k$iv$iv[index$iv$iv$iv];
                        j$iv$iv$iv = j$iv$iv$iv2;
                        if (!this.observationsProcessed.remove(value, scope2) && scope2.invalidateForResult(value) != InvalidationResult.IGNORED) {
                            if (scope2.isConditional() && !forgetConditionalScopes) {
                                this.conditionallyInvalidatedScopes.add(scope2);
                            } else {
                                this.invalidatedScopes.add(scope2);
                            }
                        }
                    }
                    slot$iv$iv$iv >>= c;
                    j$iv$iv$iv2 = j$iv$iv$iv + 1;
                }
                if (bitCount$iv$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                return;
            }
            i$iv$iv$iv++;
            value$iv = value$iv2;
            this_$iv$iv = this_$iv$iv2;
            this_$iv = this_$iv2;
            $i$f$forEachScopeOf = $i$f$forEachScopeOf2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010c A[EDGE_INSN: B:38:0x010c->B:235:0x0155 BREAK  A[LOOP:2: B:24:0x00b7->B:39:0x010e]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0262 A[EDGE_INSN: B:83:0x0262->B:269:0x029c BREAK  A[LOOP:13: B:70:0x020f->B:84:0x0264]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r52, boolean r53) {
        /*
            Method dump skipped, instructions count: 1512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    private final void cleanUpDerivedStateObservations() {
        char c;
        long j;
        ScopeMap this_$iv;
        int $i$f$removeScopeIf;
        int $i$f$removeIf;
        ScatterMap this_$iv$iv$iv;
        int $i$f$forEachIndexed;
        long[] m$iv$iv$iv;
        ScopeMap this_$iv2;
        int $i$f$removeScopeIf2;
        int $i$f$removeIf2;
        ScatterMap this_$iv$iv$iv2;
        int $i$f$forEachIndexed2;
        long[] m$iv$iv$iv2;
        int j$iv$iv$iv;
        boolean zIsEmpty;
        int j$iv$iv$iv2;
        long[] m$iv$iv$iv3;
        ScopeMap this_$iv3 = this.derivedStates;
        int $i$f$removeScopeIf3 = 0;
        MutableScatterMap this_$iv$iv = this_$iv3.getMap();
        int $i$f$removeIf3 = 0;
        MutableScatterMap this_$iv$iv$iv3 = this_$iv$iv;
        int $i$f$forEachIndexed3 = 0;
        long[] m$iv$iv$iv4 = this_$iv$iv$iv3.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv4.length - 2;
        int i$iv$iv$iv = 0;
        if (0 <= lastIndex$iv$iv$iv) {
            while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv4[i$iv$iv$iv];
                c = 7;
                j = 255;
                long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv == -9187201950435737472L) {
                    this_$iv = this_$iv3;
                    $i$f$removeScopeIf = $i$f$removeScopeIf3;
                    $i$f$removeIf = $i$f$removeIf3;
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    $i$f$forEachIndexed = $i$f$forEachIndexed3;
                    m$iv$iv$iv = m$iv$iv$iv4;
                } else {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    int j$iv$iv$iv3 = 0;
                    while (j$iv$iv$iv3 < bitCount$iv$iv$iv) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        if (!(value$iv$iv$iv$iv < 128)) {
                            this_$iv2 = this_$iv3;
                            $i$f$removeScopeIf2 = $i$f$removeScopeIf3;
                            $i$f$removeIf2 = $i$f$removeIf3;
                            this_$iv$iv$iv2 = this_$iv$iv$iv3;
                            $i$f$forEachIndexed2 = $i$f$forEachIndexed3;
                            m$iv$iv$iv2 = m$iv$iv$iv4;
                            j$iv$iv$iv = j$iv$iv$iv3;
                        } else {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv3;
                            Object obj = this_$iv$iv.keys[index$iv$iv$iv];
                            Object value$iv = this_$iv$iv.values[index$iv$iv$iv];
                            char c2 = '\b';
                            if (value$iv instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(value$iv, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet set$iv = (MutableScatterSet) value$iv;
                                this_$iv2 = this_$iv3;
                                $i$f$removeScopeIf2 = $i$f$removeScopeIf3;
                                Object[] elements$iv$iv = set$iv.elements;
                                $i$f$removeIf2 = $i$f$removeIf3;
                                long[] m$iv$iv$iv5 = set$iv.metadata;
                                int lastIndex$iv$iv$iv2 = m$iv$iv$iv5.length - 2;
                                int i$iv$iv$iv2 = 0;
                                if (0 <= lastIndex$iv$iv$iv2) {
                                    while (true) {
                                        long slot$iv$iv$iv2 = m$iv$iv$iv5[i$iv$iv$iv2];
                                        this_$iv$iv$iv2 = this_$iv$iv$iv3;
                                        $i$f$forEachIndexed2 = $i$f$forEachIndexed3;
                                        j$iv$iv$iv = j$iv$iv$iv3;
                                        int index$iv$iv$iv2 = index$iv$iv$iv;
                                        long $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = ((~slot$iv$iv$iv2) << 7) & slot$iv$iv$iv2 & (-9187201950435737472L);
                                        if ($this$maskEmptyOrDeleted$iv$iv$iv$iv2 == -9187201950435737472L) {
                                            m$iv$iv$iv2 = m$iv$iv$iv4;
                                        } else {
                                            int bitCount$iv$iv$iv2 = 8 - ((~(i$iv$iv$iv2 - lastIndex$iv$iv$iv2)) >>> 31);
                                            int j$iv$iv$iv4 = 0;
                                            while (j$iv$iv$iv4 < bitCount$iv$iv$iv2) {
                                                long value$iv$iv$iv$iv2 = slot$iv$iv$iv2 & 255;
                                                if (!(value$iv$iv$iv$iv2 < 128)) {
                                                    j$iv$iv$iv2 = j$iv$iv$iv4;
                                                    m$iv$iv$iv3 = m$iv$iv$iv4;
                                                } else {
                                                    int index$iv$iv$iv3 = (i$iv$iv$iv2 << 3) + j$iv$iv$iv4;
                                                    j$iv$iv$iv2 = j$iv$iv$iv4;
                                                    DerivedState derivedState = (DerivedState) elements$iv$iv[index$iv$iv$iv3];
                                                    m$iv$iv$iv3 = m$iv$iv$iv4;
                                                    if (!this.observations.contains(derivedState)) {
                                                        set$iv.removeElementAt(index$iv$iv$iv3);
                                                    }
                                                }
                                                slot$iv$iv$iv2 >>= c2;
                                                j$iv$iv$iv4 = j$iv$iv$iv2 + 1;
                                                m$iv$iv$iv4 = m$iv$iv$iv3;
                                            }
                                            m$iv$iv$iv2 = m$iv$iv$iv4;
                                            if (bitCount$iv$iv$iv2 != 8) {
                                                break;
                                            }
                                        }
                                        if (i$iv$iv$iv2 == lastIndex$iv$iv$iv2) {
                                            break;
                                        }
                                        i$iv$iv$iv2++;
                                        j$iv$iv$iv3 = j$iv$iv$iv;
                                        index$iv$iv$iv = index$iv$iv$iv2;
                                        this_$iv$iv$iv3 = this_$iv$iv$iv2;
                                        $i$f$forEachIndexed3 = $i$f$forEachIndexed2;
                                        m$iv$iv$iv4 = m$iv$iv$iv2;
                                        c2 = '\b';
                                    }
                                } else {
                                    this_$iv$iv$iv2 = this_$iv$iv$iv3;
                                    $i$f$forEachIndexed2 = $i$f$forEachIndexed3;
                                    m$iv$iv$iv2 = m$iv$iv$iv4;
                                    j$iv$iv$iv = j$iv$iv$iv3;
                                }
                                zIsEmpty = set$iv.isEmpty();
                            } else {
                                this_$iv2 = this_$iv3;
                                $i$f$removeScopeIf2 = $i$f$removeScopeIf3;
                                $i$f$removeIf2 = $i$f$removeIf3;
                                this_$iv$iv$iv2 = this_$iv$iv$iv3;
                                $i$f$forEachIndexed2 = $i$f$forEachIndexed3;
                                m$iv$iv$iv2 = m$iv$iv$iv4;
                                j$iv$iv$iv = j$iv$iv$iv3;
                                Intrinsics.checkNotNull(value$iv, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                DerivedState derivedState2 = (DerivedState) value$iv;
                                zIsEmpty = !this.observations.contains(derivedState2);
                            }
                            if (zIsEmpty) {
                                this_$iv$iv.removeValueAt(index$iv$iv$iv);
                            }
                        }
                        slot$iv$iv$iv >>= 8;
                        j$iv$iv$iv3 = j$iv$iv$iv + 1;
                        $i$f$removeScopeIf3 = $i$f$removeScopeIf2;
                        this_$iv3 = this_$iv2;
                        $i$f$removeIf3 = $i$f$removeIf2;
                        this_$iv$iv$iv3 = this_$iv$iv$iv2;
                        $i$f$forEachIndexed3 = $i$f$forEachIndexed2;
                        m$iv$iv$iv4 = m$iv$iv$iv2;
                    }
                    this_$iv = this_$iv3;
                    $i$f$removeScopeIf = $i$f$removeScopeIf3;
                    $i$f$removeIf = $i$f$removeIf3;
                    this_$iv$iv$iv = this_$iv$iv$iv3;
                    $i$f$forEachIndexed = $i$f$forEachIndexed3;
                    m$iv$iv$iv = m$iv$iv$iv4;
                    if (bitCount$iv$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    break;
                }
                i$iv$iv$iv++;
                $i$f$removeScopeIf3 = $i$f$removeScopeIf;
                this_$iv3 = this_$iv;
                $i$f$removeIf3 = $i$f$removeIf;
                this_$iv$iv$iv3 = this_$iv$iv$iv;
                $i$f$forEachIndexed3 = $i$f$forEachIndexed;
                m$iv$iv$iv4 = m$iv$iv$iv;
            }
        } else {
            c = 7;
            j = 255;
        }
        if (this.conditionallyInvalidatedScopes.isNotEmpty()) {
            MutableScatterSet this_$iv4 = this.conditionallyInvalidatedScopes;
            Object[] elements$iv = this_$iv4.elements;
            long[] m$iv$iv = this_$iv4.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 > lastIndex$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << c) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = slot$iv$iv & j;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            RecomposeScopeImpl scope = (RecomposeScopeImpl) elements$iv[index$iv$iv];
                            if (!scope.isConditional()) {
                                this_$iv4.removeElementAt(index$iv$iv);
                            }
                        }
                        slot$iv$iv >>= 8;
                    }
                    if (bitCount$iv$iv != 8) {
                        return;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    return;
                } else {
                    i$iv$iv++;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl it;
        DerivedState.Record record;
        int i;
        int i2;
        int j$iv$iv;
        char c;
        if (!getAreChildrenComposing() && (it = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            int i3 = 0;
            it.setUsed(true);
            boolean alreadyRead = it.recordRead(value);
            if (!alreadyRead) {
                if (value instanceof StateObjectImpl) {
                    ReaderKind.Companion companion = ReaderKind.INSTANCE;
                    ((StateObjectImpl) value).m3790recordReadInh_f27i8$runtime_release(ReaderKind.m3777constructorimpl(1));
                }
                this.observations.add(value, it);
                if (value instanceof DerivedState) {
                    DerivedState.Record record2 = ((DerivedState) value).getCurrentRecord();
                    this.derivedStates.removeScope(value);
                    ObjectIntMap this_$iv = record2.getDependencies();
                    Object[] k$iv = this_$iv.keys;
                    long[] m$iv$iv = this_$iv.metadata;
                    int lastIndex$iv$iv = m$iv$iv.length - 2;
                    int i$iv$iv = 0;
                    if (0 <= lastIndex$iv$iv) {
                        while (true) {
                            long slot$iv$iv = m$iv$iv[i$iv$iv];
                            boolean alreadyRead2 = alreadyRead;
                            record = record2;
                            ObjectIntMap this_$iv2 = this_$iv;
                            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                            if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                                i = i3;
                            } else {
                                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                                int j$iv$iv2 = 0;
                                while (j$iv$iv2 < bitCount$iv$iv) {
                                    long value$iv$iv$iv = slot$iv$iv & 255;
                                    if (!(value$iv$iv$iv < 128)) {
                                        i2 = i3;
                                        j$iv$iv = j$iv$iv2;
                                        c = '\b';
                                    } else {
                                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv2;
                                        c = '\b';
                                        StateObject dependency = (StateObject) k$iv[index$iv$iv];
                                        i2 = i3;
                                        if (!(dependency instanceof StateObjectImpl)) {
                                            j$iv$iv = j$iv$iv2;
                                        } else {
                                            ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                            j$iv$iv = j$iv$iv2;
                                            int j$iv$iv3 = ReaderKind.m3777constructorimpl(1);
                                            ((StateObjectImpl) dependency).m3790recordReadInh_f27i8$runtime_release(j$iv$iv3);
                                        }
                                        this.derivedStates.add(dependency, value);
                                    }
                                    slot$iv$iv >>= c;
                                    j$iv$iv2 = j$iv$iv + 1;
                                    i3 = i2;
                                }
                                i = i3;
                                if (bitCount$iv$iv != 8) {
                                    break;
                                }
                            }
                            if (i$iv$iv == lastIndex$iv$iv) {
                                break;
                            }
                            i$iv$iv++;
                            record2 = record;
                            this_$iv = this_$iv2;
                            alreadyRead = alreadyRead2;
                            i3 = i;
                        }
                    } else {
                        record = record2;
                    }
                    it.recordDerivedStateValue((DerivedState) value, record.getCurrentValue());
                }
            }
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        int j$iv$iv$iv;
        char c;
        ScopeMap this_$iv = this.observations;
        int $i$f$forEachScopeOf = 0;
        Object value$iv = this_$iv.getMap().get(value);
        if (value$iv == null) {
            return;
        }
        if (!(value$iv instanceof MutableScatterSet)) {
            RecomposeScopeImpl scope = (RecomposeScopeImpl) value$iv;
            if (scope.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(value, scope);
                return;
            }
            return;
        }
        ScatterSet this_$iv$iv = (MutableScatterSet) value$iv;
        Object[] k$iv$iv = this_$iv$iv.elements;
        long[] m$iv$iv$iv = this_$iv$iv.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
        int i$iv$iv$iv = 0;
        if (0 > lastIndex$iv$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
            ScopeMap this_$iv2 = this_$iv;
            int $i$f$forEachScopeOf2 = $i$f$forEachScopeOf;
            Object value$iv2 = value$iv;
            ScatterSet this_$iv$iv2 = this_$iv$iv;
            long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                int j$iv$iv$iv2 = 0;
                while (j$iv$iv$iv2 < bitCount$iv$iv$iv) {
                    long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                    if (!(value$iv$iv$iv$iv < 128)) {
                        j$iv$iv$iv = j$iv$iv$iv2;
                        c = '\b';
                    } else {
                        int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv2;
                        c = '\b';
                        RecomposeScopeImpl scope2 = (RecomposeScopeImpl) k$iv$iv[index$iv$iv$iv];
                        j$iv$iv$iv = j$iv$iv$iv2;
                        if (scope2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                            this.observationsProcessed.add(value, scope2);
                        }
                    }
                    slot$iv$iv$iv >>= c;
                    j$iv$iv$iv2 = j$iv$iv$iv + 1;
                }
                if (bitCount$iv$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                return;
            }
            i$iv$iv$iv++;
            value$iv = value$iv2;
            this_$iv$iv = this_$iv$iv2;
            this_$iv = this_$iv2;
            $i$f$forEachScopeOf = $i$f$forEachScopeOf2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void recordWriteOf(java.lang.Object r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordWriteOf(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean recompose() throws java.lang.Exception {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r2 = r1.lock
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            r1.drainPendingModificationsForCompositionLocked()     // Catch: java.lang.Throwable -> Lb6
            r5 = r20
            r6 = 0
            r7 = r5
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = r20
            r12 = 0
            androidx.compose.runtime.collection.ScopeMap r0 = r11.takeInvalidations()     // Catch: java.lang.Throwable -> L8f
            r13 = r0
            r0 = r13
            r14 = 0
            androidx.compose.runtime.tooling.CompositionObserver r15 = r1.observer()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L8f
            if (r15 == 0) goto L4f
            r16 = r3
            r3 = r1
            androidx.compose.runtime.Composition r3 = (androidx.compose.runtime.Composition) r3     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L49
            r17 = r4
            java.util.Map r4 = r0.asMap()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r18 = r5
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r5)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r15.onBeginComposition(r3, r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            goto L55
        L3b:
            r0 = move-exception
            r18 = r5
            goto L96
        L3f:
            r0 = move-exception
            r18 = r5
            goto L89
        L43:
            r0 = move-exception
            r17 = r4
            r18 = r5
            goto L96
        L49:
            r0 = move-exception
            r17 = r4
            r18 = r5
            goto L89
        L4f:
            r16 = r3
            r17 = r4
            r18 = r5
        L55:
            androidx.compose.runtime.ComposerImpl r3 = r1.composer     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            boolean r3 = r3.recompose$runtime_release(r0)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4 = r3
            r5 = 0
            if (r4 != 0) goto L62
            r1.drainPendingModificationsLocked()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
        L62:
            if (r15 == 0) goto L6d
            r19 = r0
            r0 = r1
            androidx.compose.runtime.Composition r0 = (androidx.compose.runtime.Composition) r0     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r15.onEndComposition(r0)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            goto L6f
        L6d:
            r19 = r0
        L6f:
            r0 = r3
            r4 = 0
            r5 = 1
            monitor-exit(r2)
            return r3
        L80:
            r0 = move-exception
            goto L89
        L82:
            r0 = move-exception
            r16 = r3
            r17 = r4
            r18 = r5
        L89:
            r11.invalidations = r13     // Catch: java.lang.Throwable -> L8d
            throw r0     // Catch: java.lang.Throwable -> L8d
        L8d:
            r0 = move-exception
            goto L96
        L8f:
            r0 = move-exception
            r16 = r3
            r17 = r4
            r18 = r5
        L96:
            if (r9 != 0) goto Lac
            java.util.Set<androidx.compose.runtime.RememberObserver> r3 = r7.abandonSet     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
            if (r3 != 0) goto Lac
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r3 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
            java.util.Set<androidx.compose.runtime.RememberObserver> r4 = r7.abandonSet     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
            r3.dispatchAbandons()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
        Lac:
            throw r0     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb0
        Lae:
            r0 = move-exception
            goto Lb9
        Lb0:
            r0 = move-exception
            r18.abandonChanges()     // Catch: java.lang.Throwable -> Lae
            throw r0     // Catch: java.lang.Throwable -> Lae
        Lb6:
            r0 = move-exception
            r16 = r3
        Lb9:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recompose():boolean");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        boolean z;
        int index$iv$iv = 0;
        int size = references.size();
        while (true) {
            if (index$iv$iv < size) {
                Pair item$iv$iv = references.get(index$iv$iv);
                Pair it = item$iv$iv;
                if (!Intrinsics.areEqual(it.getFirst().getComposition(), this)) {
                    z = false;
                    break;
                }
                index$iv$iv++;
            } else {
                z = true;
                break;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher manager = new RememberEventDispatcher(this.abandonSet);
        SlotTable slotTable = state.getSlotTable();
        SlotWriter writer$iv = slotTable.openWriter();
        try {
            ComposerKt.removeCurrentGroup(writer$iv, manager);
            Unit unit = Unit.INSTANCE;
            writer$iv.close(true);
            manager.dispatchRememberObservers();
        } catch (Throwable th) {
            writer$iv.close(false);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList r54) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 647
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.applyChangesInLocked(androidx.compose.runtime.changelist.ChangeList):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> block) throws Exception {
        ScopeMap invalidations = takeInvalidations();
        try {
            return block.invoke(invalidations);
        } catch (Exception e) {
            this.invalidations = invalidations;
            throw e;
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) throws Exception {
        try {
            return block.invoke();
        } catch (Throwable th) {
            if (0 == 0) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (!this.abandonSet.isEmpty()) {
            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            Object[] $this$forEach$iv = this.slotTable.getSlots();
            for (Object element$iv : $this$forEach$iv) {
                RecomposeScopeImpl recomposeScopeImpl = element$iv instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) element$iv : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        Object lock$iv = this.lock;
        synchronized (lock$iv) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionImpl delegate;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            Object lock$iv = this.lock;
            synchronized (lock$iv) {
                delegate = this.invalidationDelegate;
            }
            if (delegate != null && delegate.tryImminentInvalidation(scope, instance)) {
                return InvalidationResult.IMMINENT;
            }
            return InvalidationResult.IGNORED;
        }
        if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(scope, anchor, instance);
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getCompositionImplServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a A[Catch: all -> 0x017c, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x017c, blocks: (B:5:0x000d, B:18:0x002a, B:23:0x0034, B:31:0x005e, B:33:0x006d, B:35:0x0073), top: B:97:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014f A[Catch: all -> 0x0155, TRY_LEAVE, TryCatch #1 {all -> 0x0155, blocks: (B:37:0x0088, B:39:0x0094, B:41:0x00b5, B:43:0x00c1, B:48:0x00d1, B:74:0x014f, B:56:0x00fa, B:60:0x010b, B:64:0x0122), top: B:95:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r38, androidx.compose.runtime.Anchor r39, java.lang.Object r40) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        if (!this.observations.contains(state)) {
            this.derivedStates.removeScope(state);
        }
    }

    private final ScopeMap<RecomposeScopeImpl, Object> takeInvalidations() {
        ScopeMap invalidations = this.invalidations;
        this.invalidations = new ScopeMap<>();
        return invalidations;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        SlotTable slotTable2 = slotTable;
        Object[] $this$mapNotNull$iv = slotTable2.getSlots();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            RecomposeScopeImpl recomposeScopeImpl = element$iv$iv$iv instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) element$iv$iv$iv : null;
            if (recomposeScopeImpl != null) {
                destination$iv$iv.add(recomposeScopeImpl);
            }
        }
        List scopes = (List) destination$iv$iv;
        int index$iv = 0;
        int size = scopes.size();
        while (index$iv < size) {
            Object item$iv = scopes.get(index$iv);
            RecomposeScopeImpl scope = (RecomposeScopeImpl) item$iv;
            Anchor anchor = scope.getAnchor();
            if (anchor != null) {
                boolean value$iv = slotTable2.slotsOf$runtime_release(anchor.toIndexFor(slotTable2)).contains(scope);
                if (!value$iv) {
                    int dataIndex = ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable2.getSlots(), scope);
                    PreconditionsKt.throwIllegalStateException("Misaligned anchor " + anchor + " in scope " + scope + " encountered, scope found at " + dataIndex);
                }
            }
            index$iv++;
            slotTable2 = slotTable;
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            if (0 == 0 && !this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder holder = this.observerHolder;
        if (holder.getRoot()) {
            return holder.getObserver();
        }
        CompositionObserverHolder parentHolder = this.parent.getObserverHolder();
        CompositionObserver parentObserver = parentHolder != null ? parentHolder.getObserver() : null;
        if (!Intrinsics.areEqual(parentObserver, holder.getObserver())) {
            holder.setObserver(parentObserver);
        }
        return parentObserver;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028 A[Catch: all -> 0x00b5, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00b5, blocks: (B:5:0x0007, B:17:0x0028), top: B:51:0x0007 }] */
    @Override // androidx.compose.runtime.ReusableComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deactivate() throws java.lang.Throwable {
        /*
            r18 = this;
            r1 = r18
            java.lang.Object r2 = r1.lock
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            androidx.compose.runtime.SlotTable r0 = r1.slotTable     // Catch: java.lang.Throwable -> Lb5
            int r0 = r0.getGroupsSize()     // Catch: java.lang.Throwable -> Lb5
            if (r0 <= 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            r5 = r0
            if (r5 != 0) goto L28
            java.util.Set<androidx.compose.runtime.RememberObserver> r0 = r1.abandonSet     // Catch: java.lang.Throwable -> L23
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L23
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L20
            goto L28
        L20:
            r17 = r3
            goto L85
        L23:
            r0 = move-exception
            r17 = r3
            goto Lb8
        L28:
            java.lang.String r0 = "Compose:deactivate"
            r6 = r0
            r7 = 0
            androidx.compose.runtime.Trace r0 = androidx.compose.runtime.Trace.INSTANCE     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r0 = r0.beginSection(r6)     // Catch: java.lang.Throwable -> Lb5
            r8 = r0
            r9 = 0
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r0 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher     // Catch: java.lang.Throwable -> Lac
            java.util.Set<androidx.compose.runtime.RememberObserver> r10 = r1.abandonSet     // Catch: java.lang.Throwable -> Lac
            r0.<init>(r10)     // Catch: java.lang.Throwable -> Lac
            r10 = r0
            if (r5 == 0) goto L76
            androidx.compose.runtime.Applier<?> r0 = r1.applier     // Catch: java.lang.Throwable -> Lac
            r0.onBeginChanges()     // Catch: java.lang.Throwable -> Lac
            androidx.compose.runtime.SlotTable r0 = r1.slotTable     // Catch: java.lang.Throwable -> Lac
            r11 = r0
            r12 = 0
            androidx.compose.runtime.SlotWriter r0 = r11.openWriter()     // Catch: java.lang.Throwable -> Lac
            r13 = r0
            r14 = 0
            r15 = 0
            r0 = r13
            r16 = 0
            r17 = r3
            r3 = r10
            androidx.compose.runtime.RememberManager r3 = (androidx.compose.runtime.RememberManager) r3     // Catch: java.lang.Throwable -> L71
            androidx.compose.runtime.ComposerKt.deactivateCurrentGroup(r0, r3)     // Catch: java.lang.Throwable -> L71
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L71
            r3 = 0
            r0 = 1
            r13.close(r0)     // Catch: java.lang.Throwable -> Laa
            androidx.compose.runtime.Applier<?> r0 = r1.applier     // Catch: java.lang.Throwable -> Laa
            r0.onEndChanges()     // Catch: java.lang.Throwable -> Laa
            r10.dispatchRememberObservers()     // Catch: java.lang.Throwable -> Laa
            goto L78
        L71:
            r0 = move-exception
            r13.close(r15)     // Catch: java.lang.Throwable -> Laa
            throw r0     // Catch: java.lang.Throwable -> Laa
        L76:
            r17 = r3
        L78:
            r10.dispatchAbandons()     // Catch: java.lang.Throwable -> Laa
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Laa
            androidx.compose.runtime.Trace r0 = androidx.compose.runtime.Trace.INSTANCE     // Catch: java.lang.Throwable -> La8
            r0.endSection(r8)     // Catch: java.lang.Throwable -> La8
        L85:
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.RecomposeScopeImpl> r0 = r1.observations     // Catch: java.lang.Throwable -> La8
            r0.clear()     // Catch: java.lang.Throwable -> La8
            androidx.compose.runtime.collection.ScopeMap<java.lang.Object, androidx.compose.runtime.DerivedState<?>> r0 = r1.derivedStates     // Catch: java.lang.Throwable -> La8
            r0.clear()     // Catch: java.lang.Throwable -> La8
            androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, java.lang.Object> r0 = r1.invalidations     // Catch: java.lang.Throwable -> La8
            r0.clear()     // Catch: java.lang.Throwable -> La8
            androidx.compose.runtime.changelist.ChangeList r0 = r1.changes     // Catch: java.lang.Throwable -> La8
            r0.clear()     // Catch: java.lang.Throwable -> La8
            androidx.compose.runtime.changelist.ChangeList r0 = r1.lateChanges     // Catch: java.lang.Throwable -> La8
            r0.clear()     // Catch: java.lang.Throwable -> La8
            androidx.compose.runtime.ComposerImpl r0 = r1.composer     // Catch: java.lang.Throwable -> La8
            r0.deactivate$runtime_release()     // Catch: java.lang.Throwable -> La8
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La8
            monitor-exit(r2)
            return
        La8:
            r0 = move-exception
            goto Lb8
        Laa:
            r0 = move-exception
            goto Laf
        Lac:
            r0 = move-exception
            r17 = r3
        Laf:
            androidx.compose.runtime.Trace r3 = androidx.compose.runtime.Trace.INSTANCE     // Catch: java.lang.Throwable -> La8
            r3.endSection(r8)     // Catch: java.lang.Throwable -> La8
            throw r0     // Catch: java.lang.Throwable -> La8
        Lb5:
            r0 = move-exception
            r17 = r3
        Lb8:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.deactivate():void");
    }

    public final int composerStacksSizes$runtime_release() {
        return this.composer.stacksSize$runtime_release();
    }

    /* compiled from: Composition.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\r\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "afters", "Landroidx/collection/MutableIntList;", "leaving", "", "", "pending", "priorities", "releasing", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", "", "deactivating", "instance", "endRelativeOrder", "", "priority", "endRelativeAfter", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "forgetting", "processPendingLeaving", "recordLeaving", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Object> leaving = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();
        private final List<Object> pending = new ArrayList();
        private final MutableIntList priorities = new MutableIntList(0, 1, null);
        private final MutableIntList afters = new MutableIntList(0, 1, null);

        public RememberEventDispatcher(Set<RememberObserver> set) {
            this.abandoning = set;
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            this.remembering.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> effect) {
            this.sideEffects.add(effect);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            MutableScatterSet it = this.releasing;
            if (it == null) {
                it = ScatterSetKt.mutableScatterSetOf();
                this.releasing = it;
            }
            it.plusAssign((MutableScatterSet) instance);
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        public final void dispatchRememberObservers() {
            Object token$iv;
            processPendingLeaving(Integer.MIN_VALUE);
            if (!this.leaving.isEmpty()) {
                token$iv = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    MutableScatterSet releasing = this.releasing;
                    for (int i = this.leaving.size() - 1; -1 < i; i--) {
                        Object instance = this.leaving.get(i);
                        if (instance instanceof RememberObserver) {
                            this.abandoning.remove(instance);
                            ((RememberObserver) instance).onForgotten();
                        }
                        if (instance instanceof ComposeNodeLifecycleCallback) {
                            if (releasing != null && releasing.contains(instance)) {
                                ((ComposeNodeLifecycleCallback) instance).onRelease();
                            } else {
                                ((ComposeNodeLifecycleCallback) instance).onDeactivate();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            if (!this.remembering.isEmpty()) {
                token$iv = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List $this$fastForEach$iv = this.remembering;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        RememberObserver instance2 = (RememberObserver) item$iv;
                        this.abandoning.remove(instance2);
                        instance2.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List $this$fastForEach$iv = this.sideEffects;
                    int size = $this$fastForEach$iv.size();
                    for (int index$iv = 0; index$iv < size; index$iv++) {
                        Object item$iv = $this$fastForEach$iv.get(index$iv);
                        Function0 sideEffect = (Function0) item$iv;
                        sideEffect.invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object token$iv = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator iterator = this.abandoning.iterator();
                    while (iterator.hasNext()) {
                        RememberObserver instance = iterator.next();
                        iterator.remove();
                        instance.onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(token$iv);
                }
            }
        }

        private final void recordLeaving(Object instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            processPendingLeaving(endRelativeOrder);
            boolean z = false;
            if (endRelativeAfter >= 0 && endRelativeAfter < endRelativeOrder) {
                z = true;
            }
            if (z) {
                this.pending.add(instance);
                this.priorities.add(priority);
                this.afters.add(endRelativeAfter);
                return;
            }
            this.leaving.add(instance);
        }

        private final void processPendingLeaving(int endRelativeOrder) {
            if (!this.pending.isEmpty()) {
                int index = 0;
                List toAdd = null;
                MutableIntList toAddAfter = null;
                MutableIntList toAddPriority = null;
                while (index < this.afters.getSize()) {
                    if (endRelativeOrder <= this.afters.get(index)) {
                        Object instance = this.pending.remove(index);
                        int endRelativeAfter = this.afters.removeAt(index);
                        int priority = this.priorities.removeAt(index);
                        if (toAdd == null) {
                            toAdd = CollectionsKt.mutableListOf(instance);
                            MutableIntList it = new MutableIntList(0, 1, null);
                            it.add(endRelativeAfter);
                            toAddAfter = it;
                            MutableIntList it2 = new MutableIntList(0, 1, null);
                            it2.add(priority);
                            toAddPriority = it2;
                        } else {
                            Intrinsics.checkNotNull(toAddPriority, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                            Intrinsics.checkNotNull(toAddAfter, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                            toAdd.add(instance);
                            toAddAfter.add(endRelativeAfter);
                            toAddPriority.add(priority);
                        }
                    } else {
                        index++;
                    }
                }
                if (toAdd != null) {
                    Intrinsics.checkNotNull(toAddPriority, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    Intrinsics.checkNotNull(toAddAfter, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    int size = toAdd.size() - 1;
                    for (int i = 0; i < size; i++) {
                        int size2 = toAdd.size();
                        for (int j = i + 1; j < size2; j++) {
                            int iAfter = toAddAfter.get(i);
                            int jAfter = toAddAfter.get(j);
                            if (iAfter < jAfter || (jAfter == iAfter && toAddPriority.get(i) < toAddPriority.get(j))) {
                                CompositionKt.swap(toAdd, i, j);
                                CompositionKt.swap(toAddPriority, i, j);
                                CompositionKt.swap(toAddAfter, i, j);
                            }
                        }
                    }
                    this.leaving.addAll(toAdd);
                }
            }
        }
    }
}
